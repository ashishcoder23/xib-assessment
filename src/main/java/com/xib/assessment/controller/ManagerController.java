package com.xib.assessment.controller;

import com.xib.assessment.dto.request.ManagerRQO;
import com.xib.assessment.service.ManagerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ManagerController {

    private final ManagerService service;

    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @PostMapping("/manager")
    public Long create(@Valid @RequestBody ManagerRQO rqo) {
        return service.create(rqo);
    }
}
