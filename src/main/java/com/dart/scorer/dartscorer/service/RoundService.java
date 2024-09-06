package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.request.RoundRequestDto;
import com.dart.scorer.dartscorer.dto.response.RoundResponseDto;

import java.util.List;

public interface RoundService {
    RoundResponseDto addRound(RoundRequestDto roundRequestDto);
    RoundResponseDto getRound(Long id);
    List<RoundResponseDto> getRounds();
    RoundResponseDto updateRound(RoundRequestDto roundRequestDto);
    void deleteRound(Long id);
}
