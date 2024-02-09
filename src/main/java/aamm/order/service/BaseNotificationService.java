package aamm.order.service;

import java.util.HashMap;


import aamm.order.model.NotificationTemplate;

public abstract class BaseNotificationService implements NotificationService{
    //NotificationRepository notify;
    NotificationService notifier;
    public BaseNotificationService(){}
    public BaseNotificationService(NotificationService notify)
    {
        this.notifier = notify;
    }

    @Override
    public Object sendNotification() throws InterruptedException 
    {
        return notifier.sendNotification();
    }

    @Override
    public HashMap<String,NotificationTemplate> listNotifications()
    {
        return notifier.listNotifications();
    }

}
