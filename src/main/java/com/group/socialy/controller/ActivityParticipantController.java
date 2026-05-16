package com.group.socialy.controller;

import com.group.socialy.model.ActivityParticipant;
import com.group.socialy.service.ActivityParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-participants")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityParticipantController {

    private final ActivityParticipantService activityParticipantService;

    public ActivityParticipantController(ActivityParticipantService activityParticipantService) {
        this.activityParticipantService = activityParticipantService;
    }

    @GetMapping
    public List<ActivityParticipant> findAll() {
        return activityParticipantService.findAll();
    }

    @GetMapping("/{id}")
    public ActivityParticipant findById(@PathVariable Long id) {
        return activityParticipantService.findById(id);
    }

    @PostMapping
    public ActivityParticipant save(@RequestBody ActivityParticipant activityParticipant) {
        return activityParticipantService.save(activityParticipant);
    }

    @PutMapping("/{id}")
    public ActivityParticipant update(@PathVariable Long id, @RequestBody ActivityParticipant activityParticipant) {
        return activityParticipantService.update(id, activityParticipant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        activityParticipantService.delete(id);
    }
}