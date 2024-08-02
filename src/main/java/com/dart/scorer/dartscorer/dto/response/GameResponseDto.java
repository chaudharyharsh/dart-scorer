package com.dart.scorer.dartscorer.dto.response;

import com.dart.scorer.dartscorer.entity.Round;
import com.dart.scorer.dartscorer.entity.Score;
import com.dart.scorer.dartscorer.entity.Team;
import com.dart.scorer.dartscorer.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameResponseDto {

    private Long id;
    private GameType type;
    private Set<Team> teams;
    private Set<Round> currentRound;
    private Set<Score> score;
    private String winnerPrize;
    private Integer totalRounds;
    private Integer chancesPerRound;

}
