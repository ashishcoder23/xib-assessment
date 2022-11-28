package com.xib.assessment.dto.request;

import com.xib.assessment.dto.base.BaseRequest;
import com.xib.assessment.entity.Manager;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ManagerRQO extends BaseRequest<Manager, ManagerRQO> {
    private Long id;
    @NotNull
    private String name;

    private List<Long> teams;

    @Override
    public Manager to() {
        return to(new Manager());
    }

    @Override
    public Manager to(Manager manager) {
        manager.setId(id);
        manager.setName(name);
        return manager;
    }
}
