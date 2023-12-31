package aamm.order.service;

import java.util.HashMap;
import java.util.Queue;

import aamm.order.model.NotificationTemplate;

public interface NotificationService {
    public Object sendNotification() throws InterruptedException ;
    public HashMap<String, NotificationTemplate> listNotifications();
} 
