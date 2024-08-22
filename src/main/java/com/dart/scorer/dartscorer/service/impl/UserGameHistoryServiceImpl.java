package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.response.UserGameHistoryResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.UserGameHistoryRequestDto;
import com.dart.scorer.dartscorer.entity.UserGameHistory;
import com.dart.scorer.dartscorer.mappers.UserGameHistoryModelMapper;
import com.dart.scorer.dartscorer.repo.UserGameHistoryRepo;
import com.dart.scorer.dartscorer.service.UserGameHistoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGameHistoryServiceImpl implements UserGameHistoryService {

    @Autowired
    private UserGameHistoryRepo userGameHistoryRepo;

    @Autowired
    private UserGameHistoryModelMapper userGameHistoryModelMapper;

    @Override
    public UserGameHistoryResponseDto addUserGameHistory(UserGameHistoryRequestDto userGameHistoryRequestDto) {
        UserGameHistory  userGameHistory = this.userGameHistoryModelMapper.userGameHistoryRequestDtoToUserGameHistory(userGameHistoryRequestDto);
        this.userGameHistoryRepo.save(userGameHistory);
        UserGameHistoryResponseDto userGameHistoryResponseDto = this.userGameHistoryModelMapper.userGameHistoryToUserGameHistoryResponseDto(userGameHistory);
        return userGameHistoryResponseDto;
    }

    @Override
    public UserGameHistoryResponseDto getUserGameHistory(Long userGameHistoryId) {
        Optional<UserGameHistory> userGameHistory = this.userGameHistoryRepo.findById(userGameHistoryId);
        UserGameHistoryResponseDto userGameHistoryResponseDto;
        if(userGameHistory.isPresent()){
            userGameHistoryResponseDto = this.userGameHistoryModelMapper.userGameHistoryToUserGameHistoryResponseDto(userGameHistory.get());
        }else {
            throw new EntityNotFoundException("UserGameHistory not found with id : " +userGameHistoryId);
        }
        return userGameHistoryResponseDto;
    }

    @Override
    public List<UserGameHistoryResponseDto> getUserGameHistory() {
        List<UserGameHistory> userGameHistoryList = this.userGameHistoryRepo.findAll();
        List<UserGameHistoryResponseDto> userGameHistoryResponseDtoList = userGameHistoryList.stream().map(userGameHistory -> this.userGameHistoryModelMapper.userGameHistoryToUserGameHistoryResponseDto(userGameHistory)).toList();
        return  userGameHistoryResponseDtoList;
    }

    @Override
    public UserGameHistoryResponseDto updateUserGameHistory(UserGameHistoryRequestDto userGameHistoryRequestDto) {
        Optional<UserGameHistory> userGameHistory = this.userGameHistoryRepo.findById(userGameHistoryRequestDto.getId());
        UserGameHistoryResponseDto userGameHistoryResponseDto;
        UserGameHistory existingUserGameHistory;
        if(userGameHistory.isPresent()){
            existingUserGameHistory = userGameHistory.get();
//            existingUserGameHistory.setId(userGameHistoryRequestDto.getId());
            existingUserGameHistory.setLastPlayedOn(userGameHistoryRequestDto.getLastPlayedOn());
            existingUserGameHistory.setMatchWon(userGameHistoryRequestDto.getMatchWon());
            existingUserGameHistory.setTotalMatch(userGameHistoryRequestDto.getTotalMatch());
            existingUserGameHistory.setTotalScore(userGameHistoryRequestDto.getTotalScore());
            this.userGameHistoryRepo.save(existingUserGameHistory);
            userGameHistoryResponseDto = this.userGameHistoryModelMapper.userGameHistoryToUserGameHistoryResponseDto(existingUserGameHistory);
        }else {
            throw new RuntimeException("UserGameHistory not found with id :" + userGameHistoryRequestDto.getId());
        }
        return userGameHistoryResponseDto;
    }

    @Override
    public void deleteUserGameHistory(Long userGameHistoryId) {
        Optional<UserGameHistory> userGameHistory = this.userGameHistoryRepo.findById(userGameHistoryId);
        if(userGameHistory.isPresent()){
            this.userGameHistoryRepo.deleteById(userGameHistoryId);
        }else {
            throw new RuntimeException("UserGameHistory not found with id :" + userGameHistoryId);
        }
    }
}
