package aamm.order.service;

import aamm.order.Repository.NotificationRepository;

public abstract class BaseNotificationService implements NotificationService{
    //NotificationRepository notify;
    NotificationService notifier;

    public BaseNotificationService(NotificationService notify)
    {
        this.notifier = notify;
    }

    @Override
    public Object sendNotification(NotificationRepository repo) throws InterruptedException 
    {
        return notifier.sendNotification(repo);
    }

    @Override
    public Object listNotifications(NotificationRepository repo)
    {
        return repo.listNotifications();
    }

}
