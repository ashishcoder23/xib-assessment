package com.xib.assessment.dto.request;

import com.xib.assessment.dto.base.BaseRequest;
import com.xib.assessment.entity.Agent;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AgentRQO extends BaseRequest<Agent, AgentRQO> {

    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private Long team;

    @Override
    public Agent to() {
        return to(new Agent());
    }

    @Override
    public Agent to(Agent agent) {
        agent.setId(id);
        agent.setFirstName(firstName);
        agent.setLastName(lastName);
        return agent;
    }
}
