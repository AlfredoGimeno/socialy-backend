package com.group.socialy.service;

import com.group.socialy.model.Project;
import com.group.socialy.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Long id, Project project) {
        Project existingProject = findById(id);

        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        existingProject.setRequirements(project.getRequirements());
        existingProject.setLocation(project.getLocation());
        existingProject.setCity(project.getCity());
        existingProject.setProvince(project.getProvince());
        existingProject.setStartDate(project.getStartDate());
        existingProject.setEndDate(project.getEndDate());
        existingProject.setMaxVolunteers(project.getMaxVolunteers());
        existingProject.setStatus(project.getStatus());
        existingProject.setCategory(project.getCategory());
        existingProject.setOrganization(project.getOrganization());

        return projectRepository.save(existingProject);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}