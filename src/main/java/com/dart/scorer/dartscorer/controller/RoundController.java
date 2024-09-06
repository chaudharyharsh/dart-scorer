package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.request.RoundRequestDto;
import com.dart.scorer.dartscorer.dto.response.RoundResponseDto;
import com.dart.scorer.dartscorer.service.RoundService;
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
public class RoundController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private RoundService roundService;

    @PostMapping("/rounds")
    public ResponseEntity<Object> addRound(@RequestBody RoundRequestDto roundRequestDto) {
        log.debug("Enter addRound() in TeamController.");
        RoundResponseDto roundResponseDto = roundService.addRound(roundRequestDto);
        log.debug("Exit addRound() in TeamController.");
        return apiResponse.commonResponse(true, "Round successfully added.", HttpStatus.OK, roundResponseDto);
    }

    @GetMapping("/rounds/{roundId}")
    public ResponseEntity<Object> getRoundById(@PathVariable(name = "roundId") Long roundId) {
        log.debug("Enter getRoundById() in TeamController.");
        RoundResponseDto roundResponseDto = roundService.getRound(roundId);
        log.debug("Exit getRoundById() in TeamController.");
        return apiResponse.commonResponse(true, "Round with team id : " + roundId + " successfully fetched." , HttpStatus.OK, roundResponseDto);

    }

    @GetMapping("/rounds")
    public ResponseEntity<Object> getAllRounds(){
        log.debug("Enter getAllRounds() in TeamController.");
        List<RoundResponseDto> roundResponseDtoList = roundService.getRounds();
        log.debug("Exit getAllRounds() in TeamController.");
        return apiResponse.commonResponse(true, "Rounds successfully fetched", HttpStatus.OK, roundResponseDtoList);
    }

    @PutMapping("/rounds")
    public ResponseEntity<Object> updateRound(@RequestBody RoundRequestDto roundRequestDto) {
        log.debug("Enter updateRound() in TeamController.");
        RoundResponseDto roundResponseDto = roundService.updateRound(roundRequestDto);
        log.debug("Exit updateRound() in TeamController.");
        return apiResponse.commonResponse(true, "Round with team id : " + roundRequestDto.getId() + " successfully fetched.", HttpStatus.OK, roundResponseDto);
    }

    @DeleteMapping("/rounds/{roundId}")
    public ResponseEntity<Object> deleteRoundById(@PathVariable(name = "roundId") Long roundId) {
        log.debug("Enter deleteRoundById() in TeamController.");
        roundService.deleteRound(roundId);
        log.debug("Exit deleteRoundById() in TeamController.");
        return apiResponse.commonResponse(true, "Round with team id : " + roundId + " successfully deleted.", HttpStatus.OK, null);
    }
}
