package com.xib.assessment.controller;

import com.xib.assessment.dto.request.AgentRQO;
import com.xib.assessment.dto.request.common.QueryRQO;
import com.xib.assessment.dto.request.common.RPO;
import com.xib.assessment.dto.response.AgentDTO;
import com.xib.assessment.dto.response.AgentRPO;
import com.xib.assessment.service.AgentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AgentController {

    private final AgentService service;

    public AgentController(AgentService service) {
        this.service = service;
    }

    @GetMapping("/agent/{id}")
    public AgentRPO findAgent(@PathVariable("id") Long id) {
        return service.agentDetails(id);
    }

    @GetMapping("/list")
    public List<AgentRPO> getAllAgents() {
        return service.getAllAgents();
    }

    @PostMapping("/agent")
    public Long create(@Valid @RequestBody AgentRQO rqo) {
        return service.create(rqo);
    }

    @GetMapping("/agents")
    public RPO<List<AgentDTO>> agentsExcludedIdentity(QueryRQO query) {
        return service.agentsExcludedIdentity(query);
    }

}
