package com.group.socialy.service;

import com.group.socialy.model.ActivityParticipant;
import com.group.socialy.repository.ActivityParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityParticipantService {

    private final ActivityParticipantRepository activityParticipantRepository;

    public ActivityParticipantService(ActivityParticipantRepository activityParticipantRepository) {
        this.activityParticipantRepository = activityParticipantRepository;
    }

    public List<ActivityParticipant> findAll() {
        return activityParticipantRepository.findAll();
    }

    public ActivityParticipant findById(Long id) {
        return activityParticipantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participante de actividad no encontrado"));
    }

    public ActivityParticipant save(ActivityParticipant activityParticipant) {
        return activityParticipantRepository.save(activityParticipant);
    }

    public ActivityParticipant update(Long id, ActivityParticipant activityParticipant) {
        ActivityParticipant existingActivityParticipant = findById(id);

        existingActivityParticipant.setActivity(activityParticipant.getActivity());
        existingActivityParticipant.setUser(activityParticipant.getUser());
        existingActivityParticipant.setAttendanceStatus(activityParticipant.getAttendanceStatus());
        existingActivityParticipant.setObservations(activityParticipant.getObservations());

        return activityParticipantRepository.save(existingActivityParticipant);
    }

    public void delete(Long id) {
        activityParticipantRepository.deleteById(id);
    }
}