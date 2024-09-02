package com.dart.scorer.dartscorer.dto.response;

import com.dart.scorer.dartscorer.entity.TeamMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String roles;
    private boolean isActive;
    private TeamMember teamMember;
}
