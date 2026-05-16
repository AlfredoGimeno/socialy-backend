package com.group.socialy.controller;

import com.group.socialy.model.Activity;
import com.group.socialy.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> findAll() {
        return activityService.findAll();
    }

    @GetMapping("/{id}")
    public Activity findById(@PathVariable Long id) {
        return activityService.findById(id);
    }

    @PostMapping
    public Activity save(@RequestBody Activity activity) {
        return activityService.save(activity);
    }

    @PutMapping("/{id}")
    public Activity update(@PathVariable Long id, @RequestBody Activity activity) {
        return activityService.update(id, activity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        activityService.delete(id);
    }
}