package com.group.socialy.service;

import com.group.socialy.model.ProjectImage;
import com.group.socialy.repository.ProjectImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectImageService {

    private final ProjectImageRepository projectImageRepository;

    public ProjectImageService(ProjectImageRepository projectImageRepository) {
        this.projectImageRepository = projectImageRepository;
    }

    public List<ProjectImage> findAll() {
        return projectImageRepository.findAll();
    }

    public ProjectImage findById(Long id) {
        return projectImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen de proyecto no encontrada"));
    }

    public ProjectImage save(ProjectImage projectImage) {
        return projectImageRepository.save(projectImage);
    }

    public ProjectImage update(Long id, ProjectImage projectImage) {
        ProjectImage existingProjectImage = findById(id);

        existingProjectImage.setProject(projectImage.getProject());
        existingProjectImage.setImageUrl(projectImage.getImageUrl());
        existingProjectImage.setMainImage(projectImage.getMainImage());

        return projectImageRepository.save(existingProjectImage);
    }

    public void delete(Long id) {
        projectImageRepository.deleteById(id);
    }
}