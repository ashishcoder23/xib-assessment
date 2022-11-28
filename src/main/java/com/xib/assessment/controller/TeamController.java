package com.xib.assessment.controller;

import com.xib.assessment.dto.request.TeamRQO;
import com.xib.assessment.dto.response.TeamRPO;
import com.xib.assessment.entity.Team;
import com.xib.assessment.service.TeamService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeamController {

    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping("/teams")
    public List<TeamRPO> getAllTeams() {
        return service.getAllTeams();
    }

    @GetMapping("/team/{id}")
    public TeamRPO teamDetails(@PathVariable("id") Long id) {
        return service.teamDetails(id);
    }

    @PostMapping("/team")
    public Long create(@Valid @RequestBody TeamRQO team) {
        return service.create(team);
    }

    @PostMapping("/team/{id}/agent/{agentId}")
    public boolean assignAgentToTeam(@PathVariable("id") Long id, @PathVariable("agentId") Long agentId) {
        return service.assignAgentToTeam(id, agentId);
    }

    @GetMapping("/empty/teams")
    public List<TeamRPO> emptyTeams() {
        return service.emptyTeams();
    }
}
