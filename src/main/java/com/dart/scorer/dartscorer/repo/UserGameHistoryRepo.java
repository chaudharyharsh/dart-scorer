package com.dart.scorer.dartscorer.repo;

import com.dart.scorer.dartscorer.entity.UserGameHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGameHistoryRepo extends JpaRepository<UserGameHistory, Long> {
}
