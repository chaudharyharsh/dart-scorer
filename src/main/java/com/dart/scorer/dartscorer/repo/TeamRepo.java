package com.dart.scorer.dartscorer.repo;

import com.dart.scorer.dartscorer.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
