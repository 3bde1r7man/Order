package aamm.order.service;

import aamm.order.Repository.NotificationRepository;

//import aamm.order.Repository.ShipmentNotificatioRepository;

public class ShipmentNotificationService implements NotificationService{
    //ShipmentNotificatioRepository notification = new ShipmentNotificatioRepository();

    @Override
    public Object sendNotification(NotificationRepository repo) throws InterruptedException {
        return repo.getNotification();
    }
    
    @Override
    public Object listNotifications(NotificationRepository repo) {
        return repo.listNotifications();
    }
}
