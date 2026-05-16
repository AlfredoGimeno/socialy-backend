package com.group.socialy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "project_images")
public class ProjectImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "main_image")
    private Boolean mainImage = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}