package com.dart.scorer.dartscorer.dto.response.request;

import com.dart.scorer.dartscorer.entity.Round;
import com.dart.scorer.dartscorer.entity.Score;
import com.dart.scorer.dartscorer.entity.Team;
import com.dart.scorer.dartscorer.enums.GameType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.web.JsonPath;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRequestDto {
    private Long id;
    private GameType type;
    private Set<Team> teams;
    @JsonProperty(value = "current_round")
    private Set<Round> currentRound;
    private Set<Score> score;
    @JsonProperty(value = "winner_prize")
    private String winnerPrize;
    @JsonProperty(value = "total_rounds")
    private Integer totalRounds;
    @JsonProperty(value = "chances_per_round")
    private Integer chancesPerRound;
}
