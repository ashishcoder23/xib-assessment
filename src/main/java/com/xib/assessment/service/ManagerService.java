package com.xib.assessment.service;

import com.xib.assessment.dto.request.ManagerRQO;
import com.xib.assessment.entity.Manager;
import com.xib.assessment.repository.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepository managerRepo;

    public ManagerService(ManagerRepository managerRepo) {
        this.managerRepo = managerRepo;
    }

    public Long create(ManagerRQO rqo) {
        Manager manager = rqo.to();
        managerRepo.save(manager);
        return manager.getId();
    }
}
