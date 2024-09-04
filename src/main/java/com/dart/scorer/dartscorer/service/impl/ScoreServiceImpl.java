package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.request.ScoreRequestDto;
import com.dart.scorer.dartscorer.dto.response.ScoreResponseDto;
import com.dart.scorer.dartscorer.entity.Score;
import com.dart.scorer.dartscorer.mappers.ScoreModelMapper;
import com.dart.scorer.dartscorer.repo.ScoreRepo;
import com.dart.scorer.dartscorer.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {
    
    @Autowired
    private ScoreRepo scoreRepo;
    
    @Autowired
    private ScoreModelMapper scoreModelMapper;
    
    @Override
    public ScoreResponseDto addScore(ScoreRequestDto scoreRequestDto) {
        Score score = this.scoreModelMapper.scoreRequestDtoToScore(scoreRequestDto);
        this.scoreRepo.save(score);
        ScoreResponseDto scoreResponseDto = this.scoreModelMapper.scoreToScoreResponseDto(score);
        return scoreResponseDto;
    }

    @Override
    public ScoreResponseDto getScore(Long scoreId) {
        Optional<Score> score = this.scoreRepo.findById(scoreId);
        ScoreResponseDto scoreResponseDto;
        if (score.isPresent()) {
            scoreResponseDto = this.scoreModelMapper.scoreToScoreResponseDto(score.get());
        } else {
//            throw new EntityNotFoundException("Score not found with id : "+ roundId);
            throw new RuntimeException("Score not found with id : " + scoreId);
        }
        return scoreResponseDto;
    }

    @Override
    public List<ScoreResponseDto> getScores() {
        List<Score> scores = this.scoreRepo.findAll();
        List<ScoreResponseDto> scoreResponseDtoList = scores.stream().map(score -> {
            return this.scoreModelMapper.scoreToScoreResponseDto(score);
        }).toList();
        return scoreResponseDtoList;
    }

    @Override
    public ScoreResponseDto updateScore(ScoreRequestDto scoreRequestDto) {
        Optional<Score> score = this.scoreRepo.findById(scoreRequestDto.getId());
        ScoreResponseDto scoreResponseDto;
        Score existingScore;
        if (score.isPresent()) {
            existingScore = score.get();
            existingScore.setGameId(scoreRequestDto.getGameId());
            existingScore.setPoints(scoreRequestDto.getPoints());
            existingScore.setRound(scoreRequestDto.getRound());
            existingScore.setTeamPlayerId(scoreRequestDto.getTeamPlayerId());
            this.scoreRepo.save(existingScore);
            scoreResponseDto = this.scoreModelMapper.scoreToScoreResponseDto(existingScore);
        } else {
            throw new RuntimeException("Score not found with id :" + scoreRequestDto.getId());
        }
        return scoreResponseDto;
    }

    @Override
    public void deleteScore(Long scoreId) {
        Optional<Score> score = this.scoreRepo.findById(scoreId);
        if (score.isPresent()) {
            this.scoreRepo.deleteById(scoreId);
        } else {
            throw new RuntimeException("Score not found with id :" + scoreId);
        }
    }
}
