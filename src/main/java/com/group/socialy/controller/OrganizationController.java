package com.group.socialy.controller;

import com.group.socialy.model.Organization;
import com.group.socialy.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@CrossOrigin(origins = "http://localhost:4200")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public List<Organization> findAll() {
        return organizationService.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable Long id) {
        return organizationService.findById(id);
    }

    @PostMapping
    public Organization save(@RequestBody Organization organization) {
        return organizationService.save(organization);
    }

    @PutMapping("/{id}")
    public Organization update(@PathVariable Long id, @RequestBody Organization organization) {
        return organizationService.update(id, organization);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }
}