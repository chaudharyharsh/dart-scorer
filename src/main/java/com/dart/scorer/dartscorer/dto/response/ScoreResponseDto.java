package com.dart.scorer.dartscorer.dto.response;

import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.entity.Round;
import com.dart.scorer.dartscorer.entity.TeamMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreResponseDto {

    private Long id;
    private Set<TeamMember> teamPlayerId;
    private Game gameId;
    private Round round;
    private Integer points;
}
