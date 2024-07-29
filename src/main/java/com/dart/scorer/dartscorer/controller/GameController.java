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

@RestController("/api/v1")
@Slf4j
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    ApiResponse apiResponse;

    @PostMapping("/game")
    public ResponseEntity<Object> addGame(@RequestBody GameRequestDto gameRequestDto){
        log.debug("Enter addGame() in GameController.");
        GameResponseDto gameResponseDto = gameService.addGame(gameRequestDto);
        log.debug("Exit addGame() in GameController.");
        return apiResponse.commonResponse(true, "New Game Successfully Added.",HttpStatus.OK,gameResponseDto);
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Object> getGameById (@PathVariable (value = "id") Long id ){
        log.debug("Enter getGameById() in GameController");
        GameResponseDto gameResponseDto = gameService.getGame(id);
        log.debug("Exit getGameById() in GameController");
        return apiResponse.commonResponse(true, "Game with id "+ id + " Successfully Fetched.",HttpStatus.OK,gameResponseDto);
    }

    @GetMapping("/games")
    public ResponseEntity<Object> getAllGames (){
        log.debug("Enter getAllGames() in GameController");
        List<GameResponseDto> gameResponseDto = gameService.getAllGames();
        log.debug("Exit getAllGames() in GameController");
        return apiResponse.commonResponse(true, "Games Successfully Fetched.",HttpStatus.OK,gameResponseDto);
    }

    @DeleteMapping("/game/{id}")
    public ResponseEntity<Object>  deleteGameById(@PathVariable (value = "id") Long id){
        log.debug("Enter getAllGames() in GameController");
        gameService.deleteGame(id);
        log.debug("Exit getAllGames() in GameController");
        return apiResponse.commonResponse(true, "Game with id "+ id + " Successfully Deleted.",HttpStatus.OK,null);
    }
}
