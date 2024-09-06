package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.request.GameRequestDto;
import com.dart.scorer.dartscorer.dto.response.GameResponseDto;
import com.dart.scorer.dartscorer.entity.Game;
import com.dart.scorer.dartscorer.mappers.GameModelMapper;
import com.dart.scorer.dartscorer.repo.GameRepo;
import com.dart.scorer.dartscorer.service.GameService;
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
    public GameResponseDto addGame(GameRequestDto gameRequestDto) {
        Game game = this.gameModelMapper.gameRequestDtoToGame(gameRequestDto);
        this.gameRepo.save(game);
        GameResponseDto gameResponseDto = this.gameModelMapper.gameToGameResponseDto(game);
        return gameResponseDto;
    }

    @Override
    public GameResponseDto updateGame(GameRequestDto gameRequestDto) {
        Optional<Game> game = this.gameRepo.findById(gameRequestDto.getId());
        GameResponseDto gameResponseDto;
        Game existingGame;
        if (game.isPresent()) {
            existingGame = game.get();
            existingGame.setType(gameRequestDto.getType());
//            existingGame.setTeams(gameRequestDto.getTeams());
//            existingGame.setCurrentRound(gameRequestDto.getCurrentRound());
//            existingGame.setScore(gameRequestDto.getScore());
            existingGame.setWinnerPrize(gameRequestDto.getWinnerPrize());
            existingGame.setTotalRounds(gameRequestDto.getTotalRounds());
            existingGame.setChancesPerRound(gameRequestDto.getChancesPerRound());
            this.gameRepo.save(existingGame);
            gameResponseDto = this.gameModelMapper.gameToGameResponseDto(existingGame);
        } else {
            throw new RuntimeException("Game not found with id :" + gameRequestDto.getId());
        }
        return gameResponseDto;
    }

    @Override
    public List<GameResponseDto> getAllGames() {
        List<Game> games = this.gameRepo.findAll();
        List<GameResponseDto> gameResponseDtoList = games.stream().map(game -> {
            return this.gameModelMapper.gameToGameResponseDto(game);
        }).toList();
        return gameResponseDtoList;
    }

    @Override
    public void deleteGame(Long gameId) {
        Optional<Game> game = this.gameRepo.findById(gameId);
        if (game.isPresent()) {
            this.gameRepo.deleteById(gameId);
        } else {
            throw new RuntimeException("Game not found with id :" + gameId);
        }
    }
}
