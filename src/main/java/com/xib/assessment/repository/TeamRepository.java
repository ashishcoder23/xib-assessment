package com.xib.assessment.repository;

import com.xib.assessment.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "SELECT t from Team t LEFT OUTER JOIN Agent a ON "
            + "a.team.id = t.id where a.id = :id")
    List<Team> findByAgent(Long id);

    @Query(value = "SELECT t from Team t where t.agents is empty "
            + "OR t.managers is empty"
    )
    List<Team> findTeamsWithoutAgents();

}
