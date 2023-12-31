package aamm.order.service;

import java.util.HashMap;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.NotificationRepository;
//import aamm.order.Repository.OrderNotificationRepository;
import aamm.order.model.NotificationTemplate;

@Service
public class OrderNotifcationService implements NotificationService{
    @Autowired
    NotificationRepository repo ;

    public OrderNotifcationService(){};
    @Override
    public NotificationTemplate sendNotification() throws InterruptedException {
        return repo.getNotification();
        
    }

    @Override
    public HashMap<String, NotificationTemplate> listNotifications() {
        return repo.listNotifications();
    }
    
}
