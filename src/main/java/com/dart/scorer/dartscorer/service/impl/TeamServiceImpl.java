package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.response.TeamResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.TeamRequestDto;
import com.dart.scorer.dartscorer.entity.Team;
import com.dart.scorer.dartscorer.mappers.TeamModelMapper;
import com.dart.scorer.dartscorer.repo.TeamRepo;
import com.dart.scorer.dartscorer.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private TeamModelMapper teamModelMapper;

    @Override
    public TeamResponseDto addTeam(TeamRequestDto teamRequestDto) {
        Team team = this.teamModelMapper.teamRequestDtoToTeam(teamRequestDto);
        this.teamRepo.save(team);
        TeamResponseDto teamResponseDto = this.teamModelMapper.teamToTeamResponseDto(team);
        return teamResponseDto;
    }

    @Override
    public TeamResponseDto getTeam(Long teamId) {
        Optional<Team> team = this.teamRepo.findById(teamId);
        TeamResponseDto teamResponseDto;
        if(team.isPresent()){
            teamResponseDto = this.teamModelMapper.teamToTeamResponseDto(team.get());
        }else {
            throw new EntityNotFoundException("Team not found with id : " +teamId);
        }
        return teamResponseDto;
    }

    @Override
    public List<TeamResponseDto> getTeams(){
        List<Team> teams = this.teamRepo.findAll();
        List<TeamResponseDto> teamResponseDtoList = teams.stream().map(team -> this.teamModelMapper.teamToTeamResponseDto(team)).toList();
        return teamResponseDtoList;
    }

    @Override
    public TeamResponseDto updateTeam(TeamRequestDto teamRequestDto) {
        Optional<Team> team = this.teamRepo.findById(teamRequestDto.getId());
        TeamResponseDto teamResponseDto;
        Team existingTeam ;
        if(team.isPresent()){
            existingTeam = team.get();
//            existingTeam.setId(teamRequestDto.getId());
            existingTeam.setGameId(teamRequestDto.getGameId());
            existingTeam.setCaptainId(teamRequestDto.getCaptainId());
//            existingTeam.setTeamMembers(teamRequestDto.getTeamMembers());
//            existingTeam.setRounds(teamRequestDto.getRounds());
            existingTeam.setTeamName(teamRequestDto.getTeamName());
            existingTeam.setNoOfPlayers(teamRequestDto.getNoOfPlayers());
            existingTeam.setTeamScore(teamRequestDto.getTeamScore());
            existingTeam.setWinner(teamRequestDto.isWinner());
            this.teamRepo.save(existingTeam);
            teamResponseDto = this.teamModelMapper.teamToTeamResponseDto(existingTeam);
        }else {
            throw new RuntimeException("Team not found with id :" + teamRequestDto.getId());
        }
        return teamResponseDto;
    }

    @Override
    public void deleteTeam(Long teamId) {
        Optional<Team> team = teamRepo.findById(teamId);
        if(team.isPresent()){
            teamRepo.deleteById(teamId);
        }else {
            throw new RuntimeException("Team not found with id :" + teamId);
        }
    }
}
