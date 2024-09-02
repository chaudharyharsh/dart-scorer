package com.dart.scorer.dartscorer.service.impl;

import com.dart.scorer.dartscorer.entity.MyUserDetails;
import com.dart.scorer.dartscorer.entity.UserProfile;
import com.dart.scorer.dartscorer.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserProfile> userProfile = this.userProfileRepo.findByUserName(username);
        if(userProfile.isPresent()){
            UserProfile user = userProfile.get();
           return new MyUserDetails(user);
        }else {
            throw new UsernameNotFoundException("User not found with username : " + username);
        }
    }
}
