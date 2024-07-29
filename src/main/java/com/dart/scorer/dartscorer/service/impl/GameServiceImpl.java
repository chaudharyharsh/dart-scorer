package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.response.GameResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.GameRequestDto;
import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.mappers.GameModelMapper;
import com.dart.scorer.dartscorer.repo.GameRepo;
import com.dart.scorer.dartscorer.service.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private GameModelMapper gameModelMapper;

    @Override
    public GameResponseDto getGame(Long gameId) {
        Optional<Game> game = this.gameRepo.findById(gameId);
        GameResponseDto gameResponseDto;
        if (game.isPresent()) {
            gameResponseDto = this.gameModelMapper.gameToGameResponseDto(game.get());
        } else {
//            throw new EntityNotFoundException("Game not found with id : "+ gameId);
            throw new RuntimeException("Game not found with id : " + gameId);
        }
        return gameResponseDto;
    }

    @Override
    public GameResponseDto addGame(GameRequestDto requestDto) {
        Game game = this.gameModelMapper.gameRequestDtoToGame(requestDto);
        this.gameRepo.save(game);
        GameResponseDto savedGame = this.gameModelMapper.gameToGameResponseDto(game);
        return savedGame;
    }

    @Override
    public GameResponseDto updateGame(GameRequestDto requestDto) {
        Optional<Game> game = this.gameRepo.findById(requestDto.getId());
        GameResponseDto gameResponseDto;
        Game existingGame;
        if (game.isPresent()) {
            existingGame = game.get();
            existingGame.setType(requestDto.getType());
            existingGame.setTeams(requestDto.getTeams());
            existingGame.setCurrentRound(requestDto.getCurrentRound());
            existingGame.setScore(requestDto.getScore());
            existingGame.setWinnerPrize(requestDto.getWinnerPrize());
            existingGame.setTotalRounds(requestDto.getTotalRounds());
            existingGame.setChancesPerRound(requestDto.getChancesPerRound());
            gameResponseDto = this.gameModelMapper.gameToGameResponseDto(existingGame);
        } else {
            throw new RuntimeException("Game not found with id :" + requestDto.getId());
        }
        return gameResponseDto;
    }

    @Override
    public List<GameResponseDto> getAllGames() {
        List<Game> games = this.gameRepo.findAll();
        List<GameResponseDto> gameResponseDtos = games.stream().map(game -> {
            return this.gameModelMapper.gameToGameResponseDto(game);
        }).toList();
        return gameResponseDtos;
    }

    @Override
    public void deleteGame(Long id) {
        Optional<Game> game = this.gameRepo.findById(id);
        if (game.isPresent()) {
            this.gameRepo.deleteById(id);
        } else {
            throw new RuntimeException("Game not found with id :" + id);
        }
    }
}
