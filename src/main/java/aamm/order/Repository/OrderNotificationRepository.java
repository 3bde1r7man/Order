package aamm.order.Repository;
import aamm.order.config.JsonUtil;
import org.springframework.stereotype.Repository;
import aamm.order.model.OrderNotification;
import aamm.order.model.SimpleOrder;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


@Repository
public class OrderNotificationRepository implements NotificationRepository {

    static Queue<OrderNotification> notifications = new ConcurrentLinkedQueue<>();
    OrderNotification notification;
    @Override
    public Object generateNotification(SimpleOrder orderDetails)
    {
        notification=new OrderNotification();
        String notificationData= notification.getOrderMessage();
        String products = "";
        for(int i=0;i<orderDetails.getProducts().size();i++)
        {
            products+=orderDetails.getProducts();
        }

        notificationData=notificationData.replace("{x}", orderDetails.getCustomer());
        notificationData=notificationData.replace("{y}",products);
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
