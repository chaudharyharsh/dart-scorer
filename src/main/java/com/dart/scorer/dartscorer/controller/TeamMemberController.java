package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.response.TeamMemberResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.TeamMemberRequestDto;
import com.dart.scorer.dartscorer.service.TeamMemberService;
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
public class TeamMemberController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private TeamMemberService teamMemberService;

    @PostMapping("/teamMembers")
    public ResponseEntity<Object> addTeamMember(@RequestBody TeamMemberRequestDto teamMemberRequestDto) {

        log.debug("Enter addTeamMember() in TeamController.");
        TeamMemberResponseDto teamMemberResponseDto = teamMemberService.addTeamMember(teamMemberRequestDto);
        log.debug("Exit addTeamMember() in TeamController.");
        return apiResponse.commonResponse(true, "Team member successfully added.", HttpStatus.OK, teamMemberResponseDto);
    }

    @GetMapping("/teamMembers/{teamMemberId}")
    public ResponseEntity<Object> getTeamMemberById(@PathVariable(name = "teamMemberId") Long teamMemberId) {
        log.debug("Enter getTeamMemberById() in TeamController.");
        TeamMemberResponseDto teamMemberResponseDto = teamMemberService.getTeamMember(teamMemberId);
        log.debug("Exit getTeamMemberById() in TeamController.");
        return apiResponse.commonResponse(true, "Team member with team id : " + teamMemberId + " successfully fetched." , HttpStatus.OK, teamMemberResponseDto);

    }

    @GetMapping("/teamMembers")
    public ResponseEntity<Object> getAllTeamMembers(){
        log.debug("Enter getAllTeamMembers() in TeamController.");
        List<TeamMemberResponseDto> teamMemberResponseDtoList = teamMemberService.getTeamMembers();
        log.debug("Exit getAllTeamMembers() in TeamController.");
        return apiResponse.commonResponse(true, "Team members successfully fetched", HttpStatus.OK, teamMemberResponseDtoList);
    }

    @PutMapping("/teamMembers")
    public ResponseEntity<Object> updateTeamMember(@RequestBody TeamMemberRequestDto teamMemberRequestDto) {
        log.debug("Enter updateTeamMember() in TeamController.");
        TeamMemberResponseDto teamMemberResponseDto = teamMemberService.updateTeamMember(teamMemberRequestDto);
        log.debug("Exit updateTeamMember() in TeamController.");
        return apiResponse.commonResponse(true, "Team member with team id : " + teamMemberRequestDto.getId() + " successfully fetched.", HttpStatus.OK, teamMemberResponseDto);
    }

    @DeleteMapping("/teamMembers/{teamMemberId}")
    public ResponseEntity<Object> deleteTeamMemberById(@PathVariable(name = "teamMemberId") Long teamMemberId) {
        log.debug("Enter deleteTeamMemberById() in TeamController.");
        teamMemberService.deleteTeamMemeber(teamMemberId);
        log.debug("Exit deleteTeamMemberById() in TeamController.");
        return apiResponse.commonResponse(true, "Team member with team id : " + teamMemberId + " successfully deleted.", HttpStatus.OK, null);
    }
}
