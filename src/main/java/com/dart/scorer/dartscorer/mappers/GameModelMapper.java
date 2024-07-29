package com.dart.scorer.dartscorer.mappers;

import com.dart.scorer.dartscorer.dto.response.GameResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.GameRequestDto;
import com.dart.scorer.dartscorer.entity.Game;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameModelMapper {

    private final ModelMapper modelMapper;

    public Game gameRequestDtoToGame(GameRequestDto gameRequestDto) {
        return this.modelMapper.map(gameRequestDto, Game.class);
    }

    public GameResponseDto gameToGameResponseDto(Game game) {
        return this.modelMapper.map(game, GameResponseDto.class);
    }
}
