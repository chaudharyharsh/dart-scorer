package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.response.TeamMemberResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.TeamMemberRequestDto;
import com.dart.scorer.dartscorer.entity.TeamMember;
import com.dart.scorer.dartscorer.mappers.TeamMemberModelMapper;
import com.dart.scorer.dartscorer.repo.TeamMemberRepo;
import com.dart.scorer.dartscorer.service.TeamMemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    private TeamMemberRepo teamMemberRepo;

    @Autowired
    private TeamMemberModelMapper teamMemberModelMapper;

    @Override
    public TeamMemberResponseDto addTeamMember(TeamMemberRequestDto teamMemberRequestDto) {
        TeamMember teamMember = this.teamMemberModelMapper.teamMemberRequestDtoToTeamMember(teamMemberRequestDto);
        this.teamMemberRepo.save(teamMember);
        TeamMemberResponseDto teamMemberResponseDto = this.teamMemberModelMapper.teamMemberToTeamMemberResponseDto(teamMember);
        return teamMemberResponseDto;
    }

    @Override
    public TeamMemberResponseDto getTeamMember(Long teamMemberId) {
        Optional<TeamMember> teamMember = this.teamMemberRepo.findById(teamMemberId);
        TeamMemberResponseDto teamMemberResponseDto;
        if(teamMember.isPresent()){
            teamMemberResponseDto = this.teamMemberModelMapper.teamMemberToTeamMemberResponseDto(teamMember.get());
        }else {
            throw new EntityNotFoundException("Team Member not found with id : "+teamMemberId);
        }
        return teamMemberResponseDto;
    }

    @Override
    public List<TeamMemberResponseDto> getTeamMembers() {
        List<TeamMember> teamMembers = this.teamMemberRepo.findAll();
        List<TeamMemberResponseDto> teamMemberResponseDtoList = teamMembers.stream().map(teamMember -> this.teamMemberModelMapper.teamMemberToTeamMemberResponseDto(teamMember)).toList();
        return teamMemberResponseDtoList;
    }

    @Override
    public TeamMemberResponseDto updateTeamMember(TeamMemberRequestDto teamMemberRequestDto) {
        Optional<TeamMember> teamMember = this.teamMemberRepo.findById(teamMemberRequestDto.getId());
        TeamMemberResponseDto teamMemberResponseDto;
        TeamMember existingTeamMember ;
        if(teamMember.isPresent()){
            existingTeamMember = teamMember.get();
//            existingTeamMember.setId(teamMemberRequestDto.getId());
            existingTeamMember.setTeamId(teamMemberRequestDto.getTeamId());
            existingTeamMember.setUserId(teamMemberRequestDto.getUserId());
            this.teamMemberRepo.save(existingTeamMember);
            teamMemberResponseDto = this.teamMemberModelMapper.teamMemberToTeamMemberResponseDto(existingTeamMember);
        }else {
            throw new RuntimeException("Team not found with id :" + teamMemberRequestDto.getId());
        }
        return teamMemberResponseDto;
    }

    @Override
    public void deleteTeamMemeber(Long teamMemberId) {
        Optional<TeamMember> teamMember = this.teamMemberRepo.findById(teamMemberId);
        if(teamMember.isPresent()){
            this.teamMemberRepo.deleteById(teamMemberId);
        }else {
            throw new RuntimeException("Team not found with id :" + teamMemberId);
        }

    }
}
