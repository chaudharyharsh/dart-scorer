package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team teamId;

    @OneToMany(mappedBy = "round")
    private Set<Score> score;

    private Long currentRound;
    private Long currentRoundScore;
}
