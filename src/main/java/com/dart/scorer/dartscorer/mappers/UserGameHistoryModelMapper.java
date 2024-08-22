package com.dart.scorer.dartscorer.mappers;

import com.dart.scorer.dartscorer.dto.response.UserGameHistoryResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.UserGameHistoryRequestDto;
import com.dart.scorer.dartscorer.entity.UserGameHistory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGameHistoryModelMapper {

    private final ModelMapper modelMapper;

    public UserGameHistory userGameHistoryRequestDtoToUserGameHistory(UserGameHistoryRequestDto userGameHistoryRequestDto) {
        return this.modelMapper.map(userGameHistoryRequestDto, UserGameHistory.class);
    }

    public UserGameHistoryResponseDto userGameHistoryToUserGameHistoryResponseDto(UserGameHistory userGameHistory) {
        return this.modelMapper.map(userGameHistory, UserGameHistoryResponseDto.class);
    }
}
