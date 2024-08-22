package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.response.UserProfileResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.UserProfileRequestDto;

import java.util.List;

public interface UserProfileService {
    UserProfileResponseDto addUserProfile(UserProfileRequestDto userProfileRequestDto);
    UserProfileResponseDto getUserProfile(Long userProfileId);
    List<UserProfileResponseDto> getUserProfiles();
    UserProfileResponseDto updateUserProfile(UserProfileRequestDto userProfileRequestDto);
    void deleteUserProfile(Long userProfileId);
}
