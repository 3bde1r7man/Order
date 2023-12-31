package aamm.order.service;

import aamm.order.Repository.NotificationRepository;
//import aamm.order.Repository.OrderNotificationRepository;


public class OrderNotifcationService implements NotificationService{
    //OrderNotificationRepository notification = new OrderNotificationRepository();
    @Override
    public Object sendNotification(NotificationRepository repo) throws InterruptedException {
        return repo.getNotification();
        
    }

    @Override
    public Object listNotifications(NotificationRepository repo) {
        return repo.listNotifications();
    }
    
}
