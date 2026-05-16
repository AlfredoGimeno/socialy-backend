package com.group.socialy.service;

import com.group.socialy.model.Organization;
import com.group.socialy.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public Organization findById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organización no encontrada"));
    }

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization update(Long id, Organization organization) {
        Organization existingOrganization = findById(id);

        existingOrganization.setUser(organization.getUser());
        existingOrganization.setName(organization.getName());
        existingOrganization.setDescription(organization.getDescription());
        existingOrganization.setEmail(organization.getEmail());
        existingOrganization.setPhone(organization.getPhone());
        existingOrganization.setAddress(organization.getAddress());
        existingOrganization.setCity(organization.getCity());
        existingOrganization.setProvince(organization.getProvince());
        existingOrganization.setPostalCode(organization.getPostalCode());
        existingOrganization.setWebsite(organization.getWebsite());
        existingOrganization.setVerified(organization.getVerified());

        return organizationRepository.save(existingOrganization);
    }

    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }
}