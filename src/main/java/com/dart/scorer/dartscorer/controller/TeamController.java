package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.request.TeamRequestDto;
import com.dart.scorer.dartscorer.dto.response.TeamResponseDto;
import com.dart.scorer.dartscorer.service.TeamService;
import com.dart.scorer.dartscorer.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class TeamController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private TeamService teamService;

    @PostMapping("/teams")
    public ResponseEntity<Object> addTeam(@RequestBody TeamRequestDto teamRequestDto) {

        log.debug("Enter addTeam() in TeamController.");
        TeamResponseDto teamResponseDto = teamService.addTeam(teamRequestDto);
        log.debug("Exit addTeam() in TeamController.");
        return apiResponse.commonResponse(true, "Team successfully added.", HttpStatus.OK, teamResponseDto);
    }

    @GetMapping("/teams/{teamId}")
    public ResponseEntity<Object> getTeamById(@PathVariable(name = "teamId") Long teamId) {
        log.debug("Enter getTeamById() in TeamController.");
        TeamResponseDto teamResponseDto = teamService.getTeam(teamId);
        log.debug("Exit getTeamById() in TeamController.");
        return apiResponse.commonResponse(true, "Team with team id : " + teamId + " successfully fetched." , HttpStatus.OK, teamResponseDto);

    }

    @GetMapping("/teams")
    public ResponseEntity<Object> getAllTeams(){
        log.debug("Enter getAllTeams() in TeamController.");
        List<TeamResponseDto> teamResponseDtoList = teamService.getTeams();
        log.debug("Exit getAllTeams() in TeamController.");
        return apiResponse.commonResponse(true, "Teams successfully fetched", HttpStatus.OK, teamResponseDtoList);
    }

    @PutMapping("/teams")
    public ResponseEntity<Object> updateTeam(@RequestBody TeamRequestDto teamRequestDto) {
        log.debug("Enter updateTeam() in TeamController.");
        TeamResponseDto teamResponseDto = teamService.updateTeam(teamRequestDto);
        log.debug("Exit updateTeam() in TeamController.");
        return apiResponse.commonResponse(true, "Team with team id : " + teamRequestDto.getId() + " successfully fetched.", HttpStatus.OK, teamResponseDto);
    }

    @DeleteMapping("/teams/{teamId}")
    public ResponseEntity<Object> deleteTeamById(@PathVariable(name = "teamId") Long teamId) {
        log.debug("Enter deleteTeamById() in TeamController.");
        teamService.deleteTeam(teamId);
        log.debug("Exit deleteTeamById() in TeamController.");
        return apiResponse.commonResponse(true, "Team with team id : " + teamId + " successfully deleted.", HttpStatus.OK, null);
    }
}
