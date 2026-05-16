package com.group.socialy.controller;

import com.group.socialy.model.Notification;
import com.group.socialy.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<Notification> findAll() {
        return notificationService.findAll();
    }

    @GetMapping("/{id}")
    public Notification findById(@PathVariable Long id) {
        return notificationService.findById(id);
    }

    @PostMapping
    public Notification save(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @PutMapping("/{id}")
    public Notification update(@PathVariable Long id, @RequestBody Notification notification) {
        return notificationService.update(id, notification);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notificationService.delete(id);
    }
}