package com.dart.scorer.dartscorer.repo;

import com.dart.scorer.dartscorer.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
}
