package com.xib.assessment.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xib.assessment.dto.base.BaseResponse;
import com.xib.assessment.entity.Agent;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class AgentRPO extends BaseResponse<Agent, AgentRPO> {

    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private TeamRPO team;

    @Override
    public AgentRPO from(Agent agent) {
        id = agent.getId();
        firstName = agent.getFirstName();
        lastName = agent.getLastName();
        idNumber = agent.getIdNumber();
        team = new TeamRPO().from(agent.getTeam());
        return this;
    }

    public AgentRPO basicDetails(Agent agent) {
        id = agent.getId();
        firstName = agent.getFirstName();
        lastName = agent.getLastName();
        idNumber = agent.getIdNumber();
        return this;
    }
}
