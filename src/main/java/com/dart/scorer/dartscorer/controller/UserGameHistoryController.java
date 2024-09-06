package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.request.UserGameHistoryRequestDto;
import com.dart.scorer.dartscorer.dto.response.UserGameHistoryResponseDto;
import com.dart.scorer.dartscorer.service.UserGameHistoryService;
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
public class UserGameHistoryController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private UserGameHistoryService userGameHistoryService;

    @PostMapping("/userhistory")
    public ResponseEntity<Object> addUserGameHistory(@RequestBody UserGameHistoryRequestDto userGameHistoryRequestDto) {

        log.debug("Enter addUserGameHistory() in TeamController.");
        UserGameHistoryResponseDto userGameHistoryResponseDto = userGameHistoryService.addUserGameHistory(userGameHistoryRequestDto);
        log.debug("Exit addUserGameHistory() in TeamController.");
        return apiResponse.commonResponse(true, "User History successfully added.", HttpStatus.OK, userGameHistoryResponseDto);
    }

    @GetMapping("/userhistory/{userHistoryId}")
    public ResponseEntity<Object> getUserGameHistoryById(@PathVariable(name = "userHistoryId") Long userHistoryId) {
        log.debug("Enter getUserGameHistoryById() in TeamController.");
        UserGameHistoryResponseDto userGameHistoryResponseDto = userGameHistoryService.getUserGameHistory(userHistoryId);
        log.debug("Exit getUserGameHistoryById() in TeamController.");
        return apiResponse.commonResponse(true, "User History with team id : " + userHistoryId + " successfully fetched." , HttpStatus.OK, userGameHistoryResponseDto);

    }

    @GetMapping("/userhistory")
    public ResponseEntity<Object> getAllUserGameHistory(){
        log.debug("Enter getAllUserGameHistory() in TeamController.");
        List<UserGameHistoryResponseDto> userGameHistoryResponseDtoList = userGameHistoryService.getUserGameHistory();
        log.debug("Exit getAllUserGameHistory() in TeamController.");
        return apiResponse.commonResponse(true, "User History successfully fetched", HttpStatus.OK, userGameHistoryResponseDtoList);
    }

    @PutMapping("/userhistory")
    public ResponseEntity<Object> updateUserGameHistory(@RequestBody UserGameHistoryRequestDto userGameHistoryRequestDto) {
        log.debug("Enter updateTeam() in TeamController.");
        UserGameHistoryResponseDto userGameHistoryResponseDto = userGameHistoryService.updateUserGameHistory(userGameHistoryRequestDto);
        log.debug("Exit updateTeam() in TeamController.");
        return apiResponse.commonResponse(true, "User History with team id : " + userGameHistoryRequestDto.getId() + " successfully fetched.", HttpStatus.OK, userGameHistoryResponseDto);
    }

    @DeleteMapping("/userhistory/{userHistoryId}")
    public ResponseEntity<Object> deleteUserGameHistoryById(@PathVariable(name = "userHistoryId") Long userHistoryId) {
        log.debug("Enter deleteTeamById() in TeamController.");
        userGameHistoryService.deleteUserGameHistory(userHistoryId);
        log.debug("Exit deleteTeamById() in TeamController.");
        return apiResponse.commonResponse(true, "User History with team id : " + userHistoryId + " successfully deleted.", HttpStatus.OK, null);
    }
}
