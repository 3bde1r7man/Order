package aamm.order.Repository;

import java.util.HashMap;
import java.util.Queue;

import aamm.order.model.NotificationTemplate;
import aamm.order.model.SimpleOrder;

public interface NotificationRepository {
    public boolean Notify(SimpleOrder orderDetails);
    public NotificationTemplate getNotification()throws InterruptedException;
    public HashMap<String, NotificationTemplate> listNotifications();
}
