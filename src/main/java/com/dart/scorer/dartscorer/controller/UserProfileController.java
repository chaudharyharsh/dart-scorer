package com.dart.scorer.dartscorer.controller;

import com.dart.scorer.dartscorer.dto.request.UserProfileRequestDto;
import com.dart.scorer.dartscorer.dto.response.UserProfileResponseDto;
import com.dart.scorer.dartscorer.service.UserProfileService;
import com.dart.scorer.dartscorer.util.ApiResponse;
import com.dart.scorer.dartscorer.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/users/sign-up")
    public ResponseEntity<Object> addUser(@RequestBody UserProfileRequestDto userProfileRequestDto) {
        log.debug("Enter addUser() in UserProfileController.");
        UserProfileResponseDto userProfileResponseDto = userProfileService.addUserProfile(userProfileRequestDto);
        log.debug("Exit addUser() in UserProfileController.");
        return apiResponse.commonResponse(true, "User successfully added.", HttpStatus.OK, userProfileResponseDto);
    }

    @PostMapping("/users/admin-sign-up")
    public ResponseEntity<Object> addAdmin(@RequestBody UserProfileRequestDto userProfileRequestDto) {
        log.debug("Enter addAdmin() in UserProfileController.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(userDetail -> userDetail.getAuthority().equals("ADMIN"))){
            try {
                UserProfileResponseDto userProfileResponseDto = userProfileService.addAdmin(userProfileRequestDto);
                log.debug("Exit addAdmin() in UserProfileController.");
                return apiResponse.commonResponse(true, "Admin successfully added.", HttpStatus.OK, userProfileResponseDto);
            }catch (Exception e){
                return apiResponse.commonResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST,null);
            }
        }else{
            log.error("Only admin can create other admin.");
            return apiResponse.commonResponse(false, "Only admin can create other admin.s", HttpStatus.UNAUTHORIZED, "");
        }
    }

    @PostMapping("/users/login")
    public ResponseEntity<Object> getUser(@RequestBody UserProfileRequestDto userProfileRequestDto) {
        log.debug("Enter getUser() in UserProfileController.");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userProfileRequestDto.getUserName(), userProfileRequestDto.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(userProfileRequestDto.getUserName());
            String jwtToken = jwtUtil.generateToken(userDetails.getUsername());
            log.debug("Exit getUser() in UserProfileController.");
            return  apiResponse.commonResponse  (true,"Jwt token successfully generated.", HttpStatus.OK,jwtToken);
        }catch (Exception e){
            log.error("Exception occurred while creating authentication token in getUser() method of UserProfileController.");
            return apiResponse.commonResponse  (true,"Error Creating Authentication Token.", HttpStatus.OK,"");
        }
    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<Object> getUserById(@PathVariable(name = "userName") String userName) {
        log.debug("Enter getUserById() in UserProfileController.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName().equals(userName)) {
            UserProfileResponseDto userProfileResponseDto = userProfileService.getUserProfile(userName);
            log.debug("Exit getUserById() in UserProfileController.");
            return apiResponse.commonResponse(true, "User with username : " + userName + " successfully fetched.", HttpStatus.OK, userProfileResponseDto);
        } else {
            log.error("User cannot fetched other user's profile.");
            return apiResponse.commonResponse(false, "User with username : " + userName + " is not logged in.", HttpStatus.UNAUTHORIZED, null);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUser(){
        log.debug("Enter getAllUser() in UserProfileController.");
        List<UserProfileResponseDto> userProfileResponseDtoList = userProfileService.getUserProfiles();
        log.debug("Exit getAllUser() in UserProfileController.");
        return apiResponse.commonResponse(true, "Users successfully fetched", HttpStatus.OK, userProfileResponseDtoList);
    }

    @PutMapping("/users")
    public ResponseEntity<Object> updateUser(@RequestBody UserProfileRequestDto userProfileRequestDto) {
        log.debug("Enter updateUser() in UserProfileController.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(userProfileRequestDto.getUserName().equals(authentication.getName())){
            UserProfileResponseDto userProfileResponseDto = userProfileService.updateUserProfile(userProfileRequestDto);
            log.debug("Exit updateUser() in UserProfileController.");
            return apiResponse.commonResponse(true, "User with user username : " + userProfileRequestDto.getUserName() + " successfully updated.", HttpStatus.OK, userProfileResponseDto);
        }else{
            log.error("User cannot update other users profile. ");
            return apiResponse.commonResponse(false, "User cannot update other users profile.", HttpStatus.UNAUTHORIZED, null);
        }
    }

    @DeleteMapping("/users/{userName}")
    public ResponseEntity<Object> deleteUserByUserName(@PathVariable(name = "userName") String userName) {
        log.debug("Enter deleteUserByUserName() in UserProfileController.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals(userName) || authentication.getAuthorities().contains("ADMIN")){
            userProfileService.deleteUserProfile(userName);
            log.debug("Exit deleteUserByUserName() in UserProfileController.");
            return apiResponse.commonResponse(true, "User with username : " + userName + " successfully deleted.", HttpStatus.OK, null);
        }else {
            log.error("User can only delete their own profile.");
            return apiResponse.commonResponse(false, "User can delete only their own profile.", HttpStatus.UNAUTHORIZED, null);
        }
    }
}
