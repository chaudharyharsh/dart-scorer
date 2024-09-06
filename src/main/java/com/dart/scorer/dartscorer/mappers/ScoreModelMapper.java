package com.dart.scorer.dartscorer.mappers;

import com.dart.scorer.dartscorer.dto.request.ScoreRequestDto;
import com.dart.scorer.dartscorer.dto.response.ScoreResponseDto;
import com.dart.scorer.dartscorer.entity.Score;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScoreModelMapper {

    private final ModelMapper modelMapper;

    public Score scoreRequestDtoToScore(ScoreRequestDto scoreRequestDto) {
        return this.modelMapper.map(scoreRequestDto, Score.class);
    }

    public ScoreResponseDto scoreToScoreResponseDto(Score score) {
        return this.modelMapper.map(score, ScoreResponseDto.class);
    }
}
