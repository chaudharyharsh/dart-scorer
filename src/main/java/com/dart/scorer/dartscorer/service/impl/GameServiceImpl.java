package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.response.GameResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.GameRequestDto;
import com.dart.scorer.dartscorer.service.GameService;

import java.util.List;

public class GameServiceImpl implements GameService {
    @Override
    public GameResponseDto getGame(Long id) {
        return null;
    }

    @Override
    public GameResponseDto addGame(GameRequestDto requestDto) {
        return null;
    }

    @Override
    public GameResponseDto updateGame(Long id, GameRequestDto requestDto) {
        return null;
    }

    @Override
    public List<GameResponseDto> getAllGames() {
        return List.of();
    }
}
