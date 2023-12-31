package aamm.order.Repository;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import aamm.order.config.JsonUtil;
import aamm.order.model.ShipmentNotification;
import aamm.order.model.SimpleOrder;

public class ShipmentNotificatioRepository implements NotificationRepository {
    static Queue<ShipmentNotification> notifications = new ConcurrentLinkedQueue<>();
    ShipmentNotification notification;

    @Override
    public Object generateNotification(SimpleOrder orderDetails)
    {
        notification=new ShipmentNotification();
        String notificationData= notification.getShipmentMessage();
 
        notificationData=notificationData.replace("{x}", orderDetails.getCustomer());
        notificationData=notificationData.replace("{y}",Integer.toString(orderDetails.getId()));
        notificationData=notificationData.replace("{z}", orderDetails.getStatus());
        notifications.add(notification);
        return JsonUtil.error("Message added to the queue");
    }

    @Override
    public Object getNotification() throws InterruptedException
    {
        wait(40);
        return notifications.poll();
    }

    @Override
    public Object listNotifications()
    {
        return notifications;
    }

}
