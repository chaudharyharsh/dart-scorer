package com.dart.scorer.dartscorer.mappers;

import com.dart.scorer.dartscorer.dto.response.RoundResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.RoundRequestDto;
import com.dart.scorer.dartscorer.entity.Round;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoundModelMapper {

    private final ModelMapper modelMapper;

    public Round roundRequestDtoToRound(RoundRequestDto roundRequestDto) {
        return this.modelMapper.map(roundRequestDto, Round.class);
    }

    public RoundResponseDto roundToRoundResponseDto(Round round) {
        return this.modelMapper.map(round, RoundResponseDto.class);
    }
}
