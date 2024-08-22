package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.response.ScoreResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.ScoreRequestDto;

import java.util.List;

public interface ScoreService {
    ScoreResponseDto addScore(ScoreRequestDto scoreRequestDto);
    ScoreResponseDto getScore(Long id);
    List<ScoreResponseDto> getScores();
    ScoreResponseDto updateScore(ScoreRequestDto scoreRequestDto);
    void deleteScore(Long id);
}
