package aamm.order.Repository;

import aamm.order.model.SimpleOrder;

public interface NotificationRepository {
    public boolean Notify(SimpleOrder orderDetails);
    public Object getNotification()throws InterruptedException;
    public Object listNotifications();
}
