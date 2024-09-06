package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.request.GameRequestDto;
import com.dart.scorer.dartscorer.dto.response.GameResponseDto;

import java.util.List;

public interface GameService {

    GameResponseDto getGame(Long id);
    GameResponseDto addGame(GameRequestDto requestDto);
    GameResponseDto updateGame(GameRequestDto requestDto);
    List<GameResponseDto> getAllGames();
    void deleteGame(Long id);
}
