package com.dart.scorer.dartscorer.entity;

import com.dart.scorer.dartscorer.enums.GameType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    private GameType type;

    @OneToMany(mappedBy = "gameId")
    private Set<Team> teams;

    @OneToMany(mappedBy = "gameId")
    private Set<Round> currentRound;

    @OneToMany(mappedBy = "gameId")
    private Set<Score> score;

    @Size(max = 50)
    private String winnerPrize;

    @NotEmpty
    private Integer totalRounds;

    @NotEmpty
    private Integer chancesPerRound;
}
