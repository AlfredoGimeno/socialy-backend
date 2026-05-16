package com.group.socialy.service;

import com.group.socialy.model.VolunteerApplication;
import com.group.socialy.repository.VolunteerApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerApplicationService {

    private final VolunteerApplicationRepository volunteerApplicationRepository;

    public VolunteerApplicationService(VolunteerApplicationRepository volunteerApplicationRepository) {
        this.volunteerApplicationRepository = volunteerApplicationRepository;
    }

    public List<VolunteerApplication> findAll() {
        return volunteerApplicationRepository.findAll();
    }

    public VolunteerApplication findById(Long id) {
        return volunteerApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
    }

    public VolunteerApplication save(VolunteerApplication application) {
        return volunteerApplicationRepository.save(application);
    }

    public VolunteerApplication update(Long id, VolunteerApplication application) {
        VolunteerApplication existingApplication = findById(id);

        existingApplication.setUser(application.getUser());
        existingApplication.setProject(application.getProject());
        existingApplication.setStatus(application.getStatus());
        existingApplication.setMotivation(application.getMotivation());
        existingApplication.setObservations(application.getObservations());

        return volunteerApplicationRepository.save(existingApplication);
    }

    public void delete(Long id) {
        volunteerApplicationRepository.deleteById(id);
    }
}