package aamm.order.Repository;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import aamm.order.config.JsonUtil;
import aamm.order.model.Customer;
import aamm.order.model.NotificationTemplate;
import aamm.order.model.ShipmentNotification;
import aamm.order.model.SimpleOrder;

public class ShipmentNotificatioRepository implements NotificationRepository {
    static Queue<HashMap<NotificationTemplate,String>> notifications = new ConcurrentLinkedQueue<>();
    ShipmentNotification notification;

    @Override
    public boolean Notify(SimpleOrder orderDetails)
    {
        notification=new ShipmentNotification();
        String notificationData= notification.getMessage();
 
        notificationData=notificationData.replace("{x}", orderDetails.getCustomer());
        notificationData=notificationData.replace("{y}",Integer.toString(orderDetails.getId()));
        notificationData=notificationData.replace("{z}", orderDetails.getStatus());

        CustomerRepository customer =new CustomerRepository();

        Customer cust = customer.find(orderDetails.getCustomer());

        if(cust.getNotifyWith().size()==1)
        {
            if(cust.getNotifyWith().get(0)=="mail")
            {
                HashMap<NotificationTemplate,String> addData =new HashMap<>();
                addData.put(notification,cust.getMail());
                notifications.add(addData);
            }
            else if (cust.getNotifyWith().get(0)=="SMS") {
                HashMap<NotificationTemplate,String> addData =new HashMap<>();
                addData.put(notification,cust.getPhone());
                notifications.add(addData);
            }
        }
        else
        {
            HashMap<NotificationTemplate,String> addData =new HashMap<>();
            addData.put(notification,cust.getPhone());
            notifications.add(addData);

            HashMap<NotificationTemplate,String> addData2 =new HashMap<>();
            addData2.put(notification,cust.getMail());
            notifications.add(addData2);
        }
        return true;
    }

    @Override
    public Object getNotification() throws InterruptedException
    {
        return notifications.poll();
    }

    @Override
    public Object listNotifications()
    {
        return notifications;
    }

}
