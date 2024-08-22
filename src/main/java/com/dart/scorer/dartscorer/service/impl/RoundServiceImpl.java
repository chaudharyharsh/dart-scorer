package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.response.RoundResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.RoundRequestDto;
import com.dart.scorer.dartscorer.entity.Round;
import com.dart.scorer.dartscorer.mappers.RoundModelMapper;
import com.dart.scorer.dartscorer.repo.RoundRepo;
import com.dart.scorer.dartscorer.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundRepo roundRepo;

    @Autowired
    private RoundModelMapper roundModelMapper;

    @Override
    public RoundResponseDto addRound(RoundRequestDto roundRequestDto) {
        Round round = this.roundModelMapper.roundRequestDtoToRound(roundRequestDto);
        this.roundRepo.save(round);
        RoundResponseDto roundResponseDto = this.roundModelMapper.roundToRoundResponseDto(round);
        return roundResponseDto;
    }

    @Override
    public RoundResponseDto getRound(Long roundId) {
        Optional<Round> round = this.roundRepo.findById(roundId);
        RoundResponseDto roundResponseDto;
        if (round.isPresent()) {
            roundResponseDto = this.roundModelMapper.roundToRoundResponseDto(round.get());
        } else {
//            throw new EntityNotFoundException("Round not found with id : "+ roundId);
            throw new RuntimeException("Round not found with id : " + roundId);
        }
        return roundResponseDto;
    }

    @Override
    public List<RoundResponseDto> getRounds() {
        List<Round> rounds = this.roundRepo.findAll();
        List<RoundResponseDto> roundResponseDtoList = rounds.stream().map(round -> {
            return this.roundModelMapper.roundToRoundResponseDto(round);
        }).toList();
        return roundResponseDtoList;
    }

    @Override
    public RoundResponseDto updateRound(RoundRequestDto roundRequestDto) {
        Optional<Round> round = this.roundRepo.findById(roundRequestDto.getId());
        RoundResponseDto roundResponseDto;
        Round existingRound;
        if (round.isPresent()) {
            existingRound = round.get();
            existingRound.setGameId(roundRequestDto.getGameId());
            existingRound.setCurrentRound(roundRequestDto.getCurrentRound());
            existingRound.setTeamId(roundRequestDto.getTeamId());
            existingRound.setCurrentRoundScore(roundRequestDto.getCurrentRoundScore());
            this.roundRepo.save(existingRound);
            roundResponseDto = this.roundModelMapper.roundToRoundResponseDto(existingRound);
        } else {
            throw new RuntimeException("Round not found with id :" + roundRequestDto.getId());
        }
        return roundResponseDto;
    }

    @Override
    public void deleteRound(Long roundId) {
        Optional<Round> round = this.roundRepo.findById(roundId);
        if (round.isPresent()) {
            this.roundRepo.deleteById(roundId);
        } else {
            throw new RuntimeException("Round not found with id :" + roundId);
        }
    }
}
