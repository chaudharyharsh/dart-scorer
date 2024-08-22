package com.dart.scorer.dartscorer.mappers;

import com.dart.scorer.dartscorer.dto.response.TeamMemberResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.TeamMemberRequestDto;
import com.dart.scorer.dartscorer.entity.TeamMember;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamMemberModelMapper {

    private final ModelMapper modelMapper;

    public TeamMember teamMemberRequestDtoToTeamMember(TeamMemberRequestDto teamMemberRequestDto) {
        return this.modelMapper.map(teamMemberRequestDto, TeamMember.class);
    }

    public TeamMemberResponseDto teamMemberToTeamMemberResponseDto(TeamMember teamMember) {
        return this.modelMapper.map(teamMember, TeamMemberResponseDto.class);
    }
}
