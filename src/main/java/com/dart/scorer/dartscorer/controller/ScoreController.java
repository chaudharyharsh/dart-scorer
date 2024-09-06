package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.request.ScoreRequestDto;
import com.dart.scorer.dartscorer.dto.response.ScoreResponseDto;
import com.dart.scorer.dartscorer.service.ScoreService;
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
public class ScoreController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/scores")
    public ResponseEntity<Object> addTeam(@RequestBody ScoreRequestDto scoreRequestDto) {

        log.debug("Enter addTeam() in TeamController.");
        ScoreResponseDto scoreResponseDto = scoreService.addScore(scoreRequestDto);
        log.debug("Exit addTeam() in TeamController.");
        return apiResponse.commonResponse(true, "Team successfully added.", HttpStatus.OK, scoreResponseDto);
    }

    @GetMapping("/scores/{scoreId}")
    public ResponseEntity<Object> getTeamById(@PathVariable(name = "scoreId") Long scoreId) {
        log.debug("Enter getTeamById() in TeamController.");
        ScoreResponseDto scoreResponseDto = scoreService.getScore(scoreId);
        log.debug("Exit getTeamById() in TeamController.");
        return apiResponse.commonResponse(true, "Team with team id : " + scoreId + " successfully fetched." , HttpStatus.OK, scoreResponseDto);

    }

    @GetMapping("/scores")
    public ResponseEntity<Object> getAllTeams(){
        log.debug("Enter getAllTeams() in TeamController.");
        List<ScoreResponseDto> scoreResponseDtoList = scoreService.getScores();
        log.debug("Exit getAllTeams() in TeamController.");
        return apiResponse.commonResponse(true, "Teams successfully fetched", HttpStatus.OK, scoreResponseDtoList);
    }

    @PutMapping("/scores")
    public ResponseEntity<Object> updateTeam(@RequestBody ScoreRequestDto scoreRequestDto) {
        log.debug("Enter updateTeam() in TeamController.");
        ScoreResponseDto scoreResponseDto = scoreService.updateScore(scoreRequestDto);
        log.debug("Exit updateTeam() in TeamController.");
        return apiResponse.commonResponse(true, "Team with team id : " + scoreRequestDto.getId() + " successfully fetched.", HttpStatus.OK, scoreResponseDto);
    }

    @DeleteMapping("/scores/{scoreId}")
    public ResponseEntity<Object> deleteTeamById(@PathVariable(name = "scoreId") Long scoreId) {
        log.debug("Enter deleteTeamById() in TeamController.");
        scoreService.deleteScore(scoreId);
        log.debug("Exit deleteTeamById() in TeamController.");
        return apiResponse.commonResponse(true, "Team with team id : " + scoreId + " successfully deleted.", HttpStatus.OK, null);
    }
}
