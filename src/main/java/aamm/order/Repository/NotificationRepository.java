package aamm.order.Repository;

import aamm.order.model.SimpleOrder;

public interface NotificationRepository {
    public Object generateNotification(SimpleOrder orderDetails);
    public Object getNotification()throws InterruptedException;
    public Object listNotifications();
}
