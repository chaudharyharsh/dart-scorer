package com.dart.scorer.dartscorer.dto.response;

import com.dart.scorer.dartscorer.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameResponseDto {

    private Long id;
    private GameType type;
    private String winnerPrize;
    private Integer totalRounds;
    private Integer chancesPerRound;

}
