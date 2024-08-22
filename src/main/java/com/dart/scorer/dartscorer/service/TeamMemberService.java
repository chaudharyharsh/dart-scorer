package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.response.TeamMemberResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.TeamMemberRequestDto;

import java.util.List;

public interface TeamMemberService {
    TeamMemberResponseDto addTeamMember(TeamMemberRequestDto teamMemberRequestDto);
    TeamMemberResponseDto getTeamMember(Long id);
    List<TeamMemberResponseDto> getTeamMembers();
    TeamMemberResponseDto updateTeamMember(TeamMemberRequestDto teamMemberRequestDto);
    void deleteTeamMemeber(Long id);
}
