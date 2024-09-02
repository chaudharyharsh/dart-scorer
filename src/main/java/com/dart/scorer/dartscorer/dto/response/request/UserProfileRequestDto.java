package com.dart.scorer.dartscorer.dto.response.request;

import com.dart.scorer.dartscorer.entity.TeamMember;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequestDto {
    private Long id;

    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String lastName;
    private String email;

    @JsonProperty(value = "user_name")
    private String userName;
    private String password;
    private String roles;

    @JsonProperty(value = "is_active")
    private boolean isActive;

    @JsonProperty(value = "team_member")
    private TeamMember teamMember;
}
