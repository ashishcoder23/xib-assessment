package com.xib.assessment.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xib.assessment.dto.base.BaseResponse;
import com.xib.assessment.entity.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TeamRPO extends BaseResponse<Team, TeamRPO> {

    private Long id;

    private String name;

    private List<AgentRPO> agents;

    @Override
    public TeamRPO from(Team team) {
        id = team.getId();
        name = team.getName();
        return this;
    }
}
