package com.group.socialy.controller;

import com.group.socialy.model.ProjectImage;
import com.group.socialy.service.ProjectImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-images")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectImageController {

    private final ProjectImageService projectImageService;

    public ProjectImageController(ProjectImageService projectImageService) {
        this.projectImageService = projectImageService;
    }

    @GetMapping
    public List<ProjectImage> findAll() {
        return projectImageService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectImage findById(@PathVariable Long id) {
        return projectImageService.findById(id);
    }

    @PostMapping
    public ProjectImage save(@RequestBody ProjectImage projectImage) {
        return projectImageService.save(projectImage);
    }

    @PutMapping("/{id}")
    public ProjectImage update(@PathVariable Long id, @RequestBody ProjectImage projectImage) {
        return projectImageService.update(id, projectImage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectImageService.delete(id);
    }
}