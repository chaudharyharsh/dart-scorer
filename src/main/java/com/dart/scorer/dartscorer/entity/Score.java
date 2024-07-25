package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "player_score",
    joinColumns = @JoinColumn(name = "score_id"),
    inverseJoinColumns = @JoinColumn(name = "team_player_id"))
    private Set<TeamMember> teamPlayerId;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    @NotEmpty
    private Integer points;
}
