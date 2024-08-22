package com.dart.scorer.dartscorer.dto.response.request;

import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.entity.UserProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestDto {

    private Long id;

    @JsonProperty(value = "game_id")
    private Game gameId;

    @JsonProperty(value = "captain_id")
    private UserProfile captainId;

    @JsonProperty(value = "team_name")
    private String teamName;

    @JsonProperty(value = "no_of_players")
    private Integer noOfPlayers;

    @JsonProperty(value = "team_score")
    private Long teamScore;

    @JsonProperty(value = "is_winner")
    private boolean isWinner;
}
