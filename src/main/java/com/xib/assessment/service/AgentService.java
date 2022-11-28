package com.xib.assessment.service;

import com.xib.assessment.dto.request.AgentRQO;
import com.xib.assessment.dto.request.common.QueryRQO;
import com.xib.assessment.dto.request.common.RPO;
import com.xib.assessment.dto.response.AgentDTO;
import com.xib.assessment.dto.response.AgentRPO;
import com.xib.assessment.entity.Agent;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.util.GeneratorUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentService {

    private final AgentRepository agentRepos;

    public AgentService(AgentRepository agentRepos) {
        this.agentRepos = agentRepos;
    }

    public AgentRPO agentDetails(Long id) {
        Agent agent = agentRepos.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id"));
        return new AgentRPO().from(agent);
    }

    public List<AgentRPO> getAllAgents() {
        return agentRepos.findAll().stream().map(a -> new AgentRPO().basicDetails(a)).collect(Collectors.toList());
    }

    public Long create(AgentRQO rqo) {
        Agent agent = rqo.to();
        String idNumber = GeneratorUtil.randomIdNumber();
        while (agentRepos.existsByIdNumber(idNumber))
            idNumber = GeneratorUtil.randomIdNumber();
        agent.setIdNumber(idNumber);
        agentRepos.save(agent);
        return agent.getId();
    }

    public RPO<List<AgentDTO>> agentsExcludedIdentity(QueryRQO query) {
        Page<AgentDTO> agents =
                agentRepos.findAllByFirstNameOrLastName(query.getQuery(), query.getPageable());
        RPO<List<AgentDTO>> response = new RPO<>();
        response.setData(agents.getContent());
        response.fromPage(agents, query);
        return response;
    }


}
