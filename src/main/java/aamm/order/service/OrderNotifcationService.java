package aamm.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.NotificationRepository;
//import aamm.order.Repository.OrderNotificationRepository;

@Service
public class OrderNotifcationService implements NotificationService{
    @Autowired
    NotificationRepository repo ;

    public OrderNotifcationService(){};
    @Override
    public Object sendNotification() throws InterruptedException {
        return repo.getNotification();
        
    }

    @Override
    public Object listNotifications() {
        return repo.listNotifications();
    }
    
}
