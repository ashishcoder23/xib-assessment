package com.xib.assessment.service;

import com.xib.assessment.dto.request.TeamRQO;
import com.xib.assessment.dto.response.AgentRPO;
import com.xib.assessment.dto.response.TeamRPO;
import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepo;
    private final AgentRepository agentRepo;
    private final ManagerRepository managerRepo;

    public TeamService(TeamRepository teamRepo, AgentRepository agentRepo, ManagerRepository managerRepo) {
        this.teamRepo = teamRepo;
        this.agentRepo = agentRepo;
        this.managerRepo = managerRepo;
    }

    public List<TeamRPO> getAllTeams() {
        return teamRepo.findAll().stream().map(t -> new TeamRPO().from(t)).collect(Collectors.toList());
    }

    public TeamRPO teamDetails(Long id) {
        Team team = teamRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id"));
        TeamRPO rpo = new TeamRPO().from(team);
        rpo.setAgents(agentRepo.findByTeam(team).stream().map(a -> new AgentRPO().basicDetails(a)).collect(Collectors.toList()));
        return rpo;
    }

    public Long create(TeamRQO rqo) {
        Team team = rqo.to();
        teamRepo.save(team);
        return team.getId();
    }

    public boolean assignAgentToTeam(Long id, Long agentId) {
        Team team = teamRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid Team Id"));
        Agent agent = agentRepo.findById(agentId).orElseThrow(() -> new RuntimeException("Invalid Team Id"));
        List<Team> teams = teamRepo.findByAgent(agentId);
        if (teams.size() == 0)
            return assignToTeam(team, agent);
        return ValidateAndAssignToTeam(team, agent, teams);
    }

    private boolean ValidateAndAssignToTeam(Team team, Agent agent, List<Team> teams) {
        List<Long> managers = managerRepo.findByTeams(teams);
        List<Long> managersOfTeam = managerRepo.findByTeams(Collections.singletonList(agent.getTeam()));
        Long managerId = managersOfTeam.stream().filter(m -> containsManager(managers, m)).findFirst().orElse(null);
        if (null == managerId)
            return true;
        return assignToTeam(team, agent);
    }

    private boolean assignToTeam(Team team, Agent agent) {
        agent.setTeam(team);
        agentRepo.save(agent);
        return true;
    }

    private boolean containsManager(List<Long> managers, Long id) {
        return managers.contains(id);
    }

    public List<TeamRPO> emptyTeams() {
        return teamRepo.findTeamsWithoutAgents().stream().map(t -> new TeamRPO().from(t)).collect(Collectors.toList());
    }

}
