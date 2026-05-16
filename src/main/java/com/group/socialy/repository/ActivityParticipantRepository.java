package com.group.socialy.repository;

import com.group.socialy.model.ActivityParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityParticipantRepository extends JpaRepository<ActivityParticipant, Long> {
}