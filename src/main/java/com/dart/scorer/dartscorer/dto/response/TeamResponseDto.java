package com.dart.scorer.dartscorer.dto.response;

import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.entity.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
    private Long id;
    private Game gameId;
    private UserProfile captainId;
    private String teamName;
    private Integer noOfPlayers;
    private Long teamScore;
    private boolean isWinner;
}
