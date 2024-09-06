package com.dart.scorer.dartscorer.dto.request;

import com.dart.scorer.dartscorer.entity.Team;
import com.dart.scorer.dartscorer.entity.UserProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberRequestDto {

    private Long id;

    @JsonProperty(value = "user_id")
    private UserProfile userId;

    @JsonProperty(value = "team_id")
    private Team teamId;
}
