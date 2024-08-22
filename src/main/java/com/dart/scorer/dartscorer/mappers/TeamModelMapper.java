package com.dart.scorer.dartscorer.mappers;

import com.dart.scorer.dartscorer.dto.response.TeamResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.TeamRequestDto;
import com.dart.scorer.dartscorer.entity.Team;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamModelMapper {

    private final ModelMapper modelMapper;

    public Team teamRequestDtoToTeam(TeamRequestDto teamRequestDto) {
        return this.modelMapper.map(teamRequestDto, Team.class);
    }

    public TeamResponseDto teamToTeamResponseDto(Team team) {
        return this.modelMapper.map(team, TeamResponseDto.class);
    }
}
