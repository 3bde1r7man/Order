package aamm.order.service;

import org.springframework.scheduling.annotation.Async;

import aamm.order.Repository.NotificationRepository;
//import aamm.order.Repository.OrderNotificationRepository;
//import aamm.order.Repository.ShipmentNotificatioRepository;

//import aamm.order.Repository.NotificationRepository;

public class SMSNotificationService extends BaseNotificationService{
    String message=" Sent by SMS";
    NotificationService notification;
    public SMSNotificationService(NotificationService notifier) {
        super(notifier);
    }

    @Override
    @Async
    public Object sendNotification()throws InterruptedException {
        wait(40);
        super.sendNotification();
        sendSMSNotification();
        return true;
    }

    @Async
    public Object sendSMSNotification() throws InterruptedException
    {
        return notification.sendNotification() + message;
    }
    
}
