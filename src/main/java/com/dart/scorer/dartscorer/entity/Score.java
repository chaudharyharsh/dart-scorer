package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    private Integer points;
}
