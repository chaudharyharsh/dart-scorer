package com.dart.scorer.dartscorer.service;

import com.dart.scorer.dartscorer.dto.request.UserProfileRequestDto;
import com.dart.scorer.dartscorer.dto.response.UserProfileResponseDto;

import java.util.List;

public interface UserProfileService {
    UserProfileResponseDto addUserProfile(UserProfileRequestDto userProfileRequestDto);
    UserProfileResponseDto addAdmin(UserProfileRequestDto userProfileRequestDto);
    UserProfileResponseDto getUserProfile(String userName);
    List<UserProfileResponseDto> getUserProfiles();
    UserProfileResponseDto updateUserProfile(UserProfileRequestDto userProfileRequestDto);
    void deleteUserProfile(String userName);
}
