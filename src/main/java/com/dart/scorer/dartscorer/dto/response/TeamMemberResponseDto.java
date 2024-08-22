package com.dart.scorer.dartscorer.dto.response;

import com.dart.scorer.dartscorer.entity.Score;
import com.dart.scorer.dartscorer.entity.Team;
import com.dart.scorer.dartscorer.entity.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberResponseDto {
    private Long id;
    private UserProfile userId;
    private Team teamId;
    private Set<Score> score;
}
