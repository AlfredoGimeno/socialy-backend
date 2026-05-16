package com.group.socialy.controller;

import com.group.socialy.model.VolunteerApplication;
import com.group.socialy.service.VolunteerApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:4200")
public class VolunteerApplicationController {

    private final VolunteerApplicationService volunteerApplicationService;

    public VolunteerApplicationController(VolunteerApplicationService volunteerApplicationService) {
        this.volunteerApplicationService = volunteerApplicationService;
    }

    @GetMapping
    public List<VolunteerApplication> findAll() {
        return volunteerApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public VolunteerApplication findById(@PathVariable Long id) {
        return volunteerApplicationService.findById(id);
    }

    @PostMapping
    public VolunteerApplication save(@RequestBody VolunteerApplication application) {
        return volunteerApplicationService.save(application);
    }

    @PutMapping("/{id}")
    public VolunteerApplication update(@PathVariable Long id, @RequestBody VolunteerApplication application) {
        return volunteerApplicationService.update(id, application);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        volunteerApplicationService.delete(id);
    }
}