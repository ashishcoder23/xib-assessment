package com.xib.assessment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private Set<Agent> agents;

    @ManyToMany(mappedBy = "teams", fetch = FetchType.LAZY)
    private List<Manager> managers;
}
