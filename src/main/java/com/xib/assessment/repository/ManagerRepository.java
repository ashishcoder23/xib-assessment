package com.xib.assessment.repository;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query(value = "SELECT DISTINCT m.id from Manager m where :teams IN (m.teams)")
    List<Long> findByTeams(List<Team> teams);
}
