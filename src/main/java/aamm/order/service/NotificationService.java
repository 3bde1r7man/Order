package aamm.order.service;

import aamm.order.Repository.NotificationRepository;

public interface NotificationService {
    public Object sendNotification(NotificationRepository repo) throws InterruptedException ;
    public Object listNotifications(NotificationRepository repo);
} 
