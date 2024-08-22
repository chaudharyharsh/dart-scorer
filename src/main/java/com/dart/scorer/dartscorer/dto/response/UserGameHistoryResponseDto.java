package com.dart.scorer.dartscorer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGameHistoryResponseDto {
    private Long id;
    private Long totalMatch;
    private Long matchWon;
    private Long totalScore;
    private LocalDateTime lastPlayedOn;
}
