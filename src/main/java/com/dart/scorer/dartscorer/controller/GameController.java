package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.response.GameResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.GameRequestDto;
import com.dart.scorer.dartscorer.service.GameService;
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
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    ApiResponse apiResponse;

    @PostMapping("/games")
    public ResponseEntity<Object> addGame(@RequestBody GameRequestDto gameRequestDto){
        log.debug("Enter addGame() in GameController.");
        GameResponseDto gameResponseDto = gameService.addGame(gameRequestDto);
        log.debug("Exit addGame() in GameController.");
        return apiResponse.commonResponse(true, "New game successfully added.",HttpStatus.CREATED,gameResponseDto);
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<Object> getGameById (@PathVariable (value = "gameId") Long gameId ){
        log.debug("Enter getGameById() in GameController");
        GameResponseDto gameResponseDto = gameService.getGame(gameId);
        log.debug("Exit getGameById() in GameController");
        return apiResponse.commonResponse(true, "Game with id "+ gameId + " successfully fetched.",HttpStatus.OK,gameResponseDto);
    }

    @GetMapping("/games")
    public ResponseEntity<Object> getAllGames (){
        log.debug("Enter getAllGames() in GameController");
        List<GameResponseDto> gameResponseDto = gameService.getAllGames();
        log.debug("Exit getAllGames() in GameController");
        return apiResponse.commonResponse(true, "Games successfully fetched.",HttpStatus.OK,gameResponseDto);
    }

    @PutMapping("/games")
    public ResponseEntity<Object> update(@RequestBody GameRequestDto gameRequestDto){
        log.debug("Enter update() in GameController.");
        GameResponseDto gameResponseDto = gameService.updateGame(gameRequestDto);
        log.debug("Exit update() in GameController.");
        return apiResponse.commonResponse(true, "Game with id "+ gameRequestDto.getId() + " successfully updated.",HttpStatus.OK,gameResponseDto);
    }

    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<Object>  deleteGameById(@PathVariable (value = "gameId") Long gameId){
        log.debug("Enter getAllGames() in GameController");
        gameService.deleteGame(gameId);
        log.debug("Exit getAllGames() in GameController");
        return apiResponse.commonResponse(true, "Game with id "+ gameId + " successfully deleted.",HttpStatus.OK,null);
    }
}
