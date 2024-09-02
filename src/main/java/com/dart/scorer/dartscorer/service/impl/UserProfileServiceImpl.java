package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.dto.response.UserProfileResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.UserProfileRequestDto;
import com.dart.scorer.dartscorer.entity.UserProfile;
import com.dart.scorer.dartscorer.mappers.UserProfileModelMapper;
import com.dart.scorer.dartscorer.repo.UserProfileRepo;
import com.dart.scorer.dartscorer.service.UserProfileService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    private UserProfileModelMapper userProfileModelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserProfileResponseDto addUserProfile(UserProfileRequestDto userProfileRequestDto) {
        UserProfile userProfile = this.userProfileModelMapper.userProfileRequestDtoToUserProfile(userProfileRequestDto);
        userProfile.setPassword(passwordEncoder.encode(userProfileRequestDto.getPassword()));
        userProfile.setRoles(userProfileRequestDto.getRoles().toUpperCase());
        this.userProfileRepo.save(userProfile);
        UserProfileResponseDto userProfileResponseDto = this.userProfileModelMapper.userProfileToUserProfileResponseDto(userProfile);
        return userProfileResponseDto;
    }

    @Override
    public UserProfileResponseDto getUserProfile(Long userProfileId) {
        Optional<UserProfile> userProfile = this.userProfileRepo.findById(userProfileId);
        UserProfileResponseDto userProfileResponseDto;
        if(userProfile.isPresent()){
            userProfileResponseDto = this.userProfileModelMapper.userProfileToUserProfileResponseDto(userProfile.get());
        }else {
            throw new EntityNotFoundException("UserProfile not found with id : " + userProfileId);
        }
        return userProfileResponseDto;
    }

    @Override
    public List<UserProfileResponseDto> getUserProfiles() {
        List<UserProfile> userProfiles = this.userProfileRepo.findAll();
        List<UserProfileResponseDto> userProfileResponseDtoList = userProfiles.stream().map(userProfile -> {
            return this.userProfileModelMapper.userProfileToUserProfileResponseDto(userProfile);
        }).toList();
        return userProfileResponseDtoList;
    }

    @Override
    public UserProfileResponseDto updateUserProfile(UserProfileRequestDto userProfileRequestDto) {
        Optional<UserProfile> existingUserProfile = this.userProfileRepo.findById(userProfileRequestDto.getId());
        UserProfile userProfile;
        UserProfileResponseDto userProfileResponseDto;
        if(existingUserProfile.isPresent()){
            userProfile = existingUserProfile.get();
            userProfile.setFirstName(userProfileRequestDto.getFirstName());
            userProfile.setLastName(userProfileRequestDto.getLastName());
            userProfile.setEmail(userProfileRequestDto.getEmail());
            userProfile.setActive(userProfileRequestDto.isActive());
            userProfile.setUserName(userProfileRequestDto.getUserName());
            userProfile.setPassword(passwordEncoder.encode(userProfileRequestDto.getPassword()));
            userProfile.setRoles(userProfileRequestDto.getRoles().toUpperCase());
            this.userProfileRepo.save(userProfile);
            userProfileResponseDto = this.userProfileModelMapper.userProfileToUserProfileResponseDto(userProfile);
        }else {
            throw new EntityNotFoundException("UserProfile not found with id :" + userProfileRequestDto.getId());
        }
        return  userProfileResponseDto;
    }

    @Override
    public void deleteUserProfile(Long userProfileId) {
        Optional<UserProfile> userProfile = this.userProfileRepo.findById(userProfileId);
        if (userProfile.isPresent()) {
            this.userProfileRepo.deleteById(userProfileId);
        } else {
            throw new EntityNotFoundException("Game not found with id :" + userProfileId);
        }
    }
}
