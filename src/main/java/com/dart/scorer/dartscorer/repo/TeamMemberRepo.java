package com.dart.scorer.dartscorer.repo;

import com.dart.scorer.dartscorer.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepo extends JpaRepository<TeamMember, Long> {
}
