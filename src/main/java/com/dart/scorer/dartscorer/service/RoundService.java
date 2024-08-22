package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.response.RoundResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.RoundRequestDto;

import java.util.List;

public interface RoundService {
    RoundResponseDto addRound(RoundRequestDto roundRequestDto);
    RoundResponseDto getRound(Long id);
    List<RoundResponseDto> getRounds();
    RoundResponseDto updateRound(RoundRequestDto roundRequestDto);
    void deleteRound(Long id);
}
