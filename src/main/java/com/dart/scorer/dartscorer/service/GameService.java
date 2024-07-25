package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.response.GameResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.GameRequestDto;

import java.util.List;

public interface GameService {

    GameResponseDto getGame(Long id);
    GameResponseDto addGame(GameRequestDto requestDto);
    GameResponseDto updateGame(Long id,GameRequestDto requestDto);
    List<GameResponseDto> getAllGames();

}