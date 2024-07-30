package com.dart.scorer.dartscorer.repo;

import com.dart.scorer.dartscorer.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game,Long> {
}
