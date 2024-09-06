package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.request.TeamRequestDto;
import com.dart.scorer.dartscorer.dto.response.TeamResponseDto;

import java.util.List;

public interface TeamService {
    TeamResponseDto addTeam(TeamRequestDto teamRequestDto);
    TeamResponseDto getTeam(Long id);
    List<TeamResponseDto> getTeams();
    TeamResponseDto updateTeam(TeamRequestDto teamRequestDto);
    void deleteTeam(Long id);
}
