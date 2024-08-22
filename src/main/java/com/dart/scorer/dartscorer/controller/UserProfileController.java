package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.response.UserProfileResponseDto;
import com.dart.scorer.dartscorer.dto.response.request.UserProfileRequestDto;
import com.dart.scorer.dartscorer.service.UserProfileService;
import com.dart.scorer.dartscorer.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class UserProfileController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserProfileRequestDto userProfileRequestDto) {

        log.debug("Enter addUser() in TeamController.");
        UserProfileResponseDto userProfileResponseDto = userProfileService.addUserProfile(userProfileRequestDto);
        log.debug("Exit addUser() in TeamController.");
        return apiResponse.commonResponse(true, "User successfully added.", HttpStatus.OK, userProfileResponseDto);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable(name = "userId") Long userId) {
        log.debug("Enter getUserById() in TeamController.");
        UserProfileResponseDto userProfileResponseDto = userProfileService.getUserProfile(userId);
        log.debug("Exit getUserById() in TeamController.");
        return apiResponse.commonResponse(true, "User with user id : " + userId + " successfully fetched." , HttpStatus.OK, userProfileResponseDto);

    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUser(){
        log.debug("Enter getAllUser() in TeamController.");
        List<UserProfileResponseDto> userProfileResponseDtoList = userProfileService.getUserProfiles();
        log.debug("Exit getAllUser() in TeamController.");
        return apiResponse.commonResponse(true, "Users successfully fetched", HttpStatus.OK, userProfileResponseDtoList);
    }

    @PutMapping("/users")
    public ResponseEntity<Object> updateUser(@RequestBody UserProfileRequestDto userProfileRequestDto) {
        log.debug("Enter updateUser() in TeamController.");
        UserProfileResponseDto userProfileResponseDto = userProfileService.updateUserProfile(userProfileRequestDto);
        log.debug("Exit updateUser() in TeamController.");
        return apiResponse.commonResponse(true, "User with user id : " + userProfileRequestDto.getId() + " successfully fetched.", HttpStatus.OK, userProfileResponseDto);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Object> deleteUserById(@PathVariable(name = "userId") Long userId) {
        log.debug("Enter deleteUserById() in TeamController.");
        userProfileService.deleteUserProfile(userId);
        log.debug("Exit deleteUserById() in TeamController.");
        return apiResponse.commonResponse(true, "User with user id : " + userId + " successfully deleted.", HttpStatus.OK, null);
    }
}
