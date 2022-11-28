package com.xib.assessment.repository;

import com.xib.assessment.dto.response.AgentDTO;
import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    List<Agent> findByTeam(Team team);

    boolean existsByIdNumber(String idNumber);

    @Query(value = "Select DISTINCT NEW com.xib.assessment.dto.response.AgentDTO "
            + "(a.id, a.firstName, a.lastName) from Agent a where "
            + "(:search IS NULL OR a.firstName LIKE %:search% OR a.lastName LIKE %:search% ) ")
    Page<AgentDTO> findAllByFirstNameOrLastName(String search, Pageable pageable);
}
