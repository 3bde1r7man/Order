package aamm.order.service;

import java.util.HashMap;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.NotificationRepository;
import aamm.order.model.NotificationTemplate;

//import aamm.order.Repository.ShipmentNotificatioRepository;
@Service
public class ShipmentNotificationService implements NotificationService{
    @Autowired
    NotificationRepository repo;
    public ShipmentNotificationService(){};
    @Override
    public Object sendNotification() throws InterruptedException {
        return repo.getNotification();
    }
    
    @Override
    public HashMap<String,NotificationTemplate> listNotifications() {
        return repo.listNotifications();
    }
}
