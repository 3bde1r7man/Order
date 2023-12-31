package aamm.order.service;

import aamm.order.Repository.NotificationRepository;
//import aamm.order.Repository.OrderNotificationRepository;
//import aamm.order.Repository.ShipmentNotificatioRepository;

//import aamm.order.Repository.NotificationRepository;

public class SMSNotificationService extends BaseNotificationService{
    String message=" Sent by SMS";
    public SMSNotificationService(NotificationService notifier) {
        super(notifier);
    }

    @Override
    public Object sendNotification(NotificationRepository repo)throws InterruptedException {
        super.sendNotification(repo);
        sendSMSNotification(repo);
        return true;
    }

    public Object sendSMSNotification(NotificationRepository notification) throws InterruptedException
    {
        return notification.getNotification() + message;
    }
    
}
