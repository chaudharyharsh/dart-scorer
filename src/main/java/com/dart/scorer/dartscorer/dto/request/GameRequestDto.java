package com.dart.scorer.dartscorer.dto.request;

import com.dart.scorer.dartscorer.enums.GameType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRequestDto {
    private Long id;

    private GameType type;

    @JsonProperty(value = "winner_prize")
    private String winnerPrize;

    @JsonProperty(value = "total_rounds")
    private Integer totalRounds;

    @JsonProperty(value = "chances_per_round")
    private Integer chancesPerRound;
}
