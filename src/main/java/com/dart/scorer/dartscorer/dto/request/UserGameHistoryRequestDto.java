package com.dart.scorer.dartscorer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGameHistoryRequestDto {

    private Long id;

    @JsonProperty(value = "total_match")
    private Long totalMatch;

    @JsonProperty(value = "match_won")
    private Long matchWon;

    @JsonProperty(value = "total_score")
    private Long totalScore;

    @JsonProperty(value = "last_played_on")
    private LocalDateTime lastPlayedOn;
}
