package com.dart.scorer.dartscorer.dto.request;

import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.entity.Round;
import com.dart.scorer.dartscorer.entity.TeamMember;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreRequestDto {

    private Long id;

    @JsonProperty(value = "team_player_id")
    private Set<TeamMember> teamPlayerId;

    @JsonProperty(value = "game_id")
    private Game gameId;

    private Round round;

    private Integer points;
}
