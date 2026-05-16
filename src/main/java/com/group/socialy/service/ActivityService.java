package com.group.socialy.service;

import com.group.socialy.model.Activity;
import com.group.socialy.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity findById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity update(Long id, Activity activity) {
        Activity existingActivity = findById(id);

        existingActivity.setProject(activity.getProject());
        existingActivity.setTitle(activity.getTitle());
        existingActivity.setDescription(activity.getDescription());
        existingActivity.setActivityDate(activity.getActivityDate());
        existingActivity.setLocation(activity.getLocation());
        existingActivity.setMaxParticipants(activity.getMaxParticipants());

        return activityRepository.save(existingActivity);
    }

    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}