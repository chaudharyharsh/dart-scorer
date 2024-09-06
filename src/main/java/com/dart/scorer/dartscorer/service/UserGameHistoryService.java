package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.request.UserGameHistoryRequestDto;
import com.dart.scorer.dartscorer.dto.response.UserGameHistoryResponseDto;

import java.util.List;

public interface UserGameHistoryService {
    UserGameHistoryResponseDto addUserGameHistory(UserGameHistoryRequestDto userGameHistoryRequestDto);
    UserGameHistoryResponseDto getUserGameHistory(Long id);
    List<UserGameHistoryResponseDto> getUserGameHistory();
    UserGameHistoryResponseDto updateUserGameHistory(UserGameHistoryRequestDto userGameHistoryRequestDto);
    void deleteUserGameHistory(Long id);
}
