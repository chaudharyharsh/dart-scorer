package com.dart.scorer.dartscorer.dto.response;

import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.entity.Score;
import com.dart.scorer.dartscorer.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundResponseDto {
    private Long id;
    private Game gameId;
    private Team teamId;
    private Set<Score> score;
    private Long currentRound;
    private Long currentRoundScore;
}
