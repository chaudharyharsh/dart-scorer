package com.dart.scorer.dartscorer.repo;

import com.dart.scorer.dartscorer.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserName(String userName);
}
