package com.xib.assessment.dto.request;

import com.xib.assessment.dto.base.BaseRequest;
import com.xib.assessment.entity.Team;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TeamRQO extends BaseRequest<Team, TeamRQO> {

    private Long id;
    @NotNull
    private String name;

    @Override
    public Team to() {
        return to(new Team());
    }

    @Override
    public Team to(Team team) {
        team.setId(id);
        team.setName(name);
        return team;
    }

}
