package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserProfile userId;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teamId;

    @ManyToMany(mappedBy = "teamPlayerId")
    private Set<Score> score;
}
