package aamm.order.service;

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
    public Object listNotifications()
    {
        return notifier.listNotifications();
    }

}
