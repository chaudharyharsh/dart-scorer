package com.dart.scorer.dartscorer.repo;

import com.dart.scorer.dartscorer.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepo extends JpaRepository<Score,Long> {
}
