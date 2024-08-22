package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserProfile userId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teamId;

    @ManyToMany(mappedBy = "teamPlayerId")
    private Set<Score> score;
}
