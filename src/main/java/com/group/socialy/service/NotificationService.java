package com.group.socialy.service;

import com.group.socialy.model.Notification;
import com.group.socialy.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public Notification findById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification update(Long id, Notification notification) {
        Notification existingNotification = findById(id);

        existingNotification.setUser(notification.getUser());
        existingNotification.setTitle(notification.getTitle());
        existingNotification.setMessage(notification.getMessage());
        existingNotification.setReadStatus(notification.getReadStatus());

        return notificationRepository.save(existingNotification);
    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}