package com.dart.scorer.dartscorer.mappers;

import com.dart.scorer.dartscorer.dto.request.UserProfileRequestDto;
import com.dart.scorer.dartscorer.dto.response.UserProfileResponseDto;
import com.dart.scorer.dartscorer.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileModelMapper {

    private final ModelMapper modelMapper;

    public UserProfile userProfileRequestDtoToUserProfile(UserProfileRequestDto userProfileRequestDto) {
        return this.modelMapper.map(userProfileRequestDto, UserProfile.class);
    }

    public UserProfileResponseDto userProfileToUserProfileResponseDto(UserProfile userProfile) {
        return this.modelMapper.map(userProfile, UserProfileResponseDto.class);
    }
}
