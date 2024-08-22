package com.dart.scorer.dartscorer.dto.response.request;

import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.entity.Score;
import com.dart.scorer.dartscorer.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoundRequestDto {

    private Long id;

    @JsonProperty(value = "game_id")
    private Game gameId;

    @JsonProperty(value = "team_id")
    private Team teamId;

    @JsonProperty(value = "current_round")
    private Long currentRound;

    @JsonProperty(value = "current_round_score")
    private Long currentRoundScore;
}
