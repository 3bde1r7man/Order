package aamm.order.Repository;
import aamm.order.config.JsonUtil;
import org.springframework.stereotype.Repository;

import aamm.order.model.ContactType;
import aamm.order.model.Customer;
import aamm.order.model.NotificationTemplate;
import aamm.order.model.OrderNotification;
import aamm.order.model.SimpleOrder;
import aamm.order.model.ContactType;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


@Repository
public class OrderNotificationRepository implements NotificationRepository {

    public static HashMap<String, NotificationTemplate> notifications = new HashMap<String, NotificationTemplate>();
    long id = 1;


    OrderNotification notification;


    public void save(NotificationTemplate notificationTemplate) {
        notificationTemplate.setId(id++);
        notifications.put(notificationTemplate.getContactInfo(), notificationTemplate);
        
    }
    
    @Override
    public boolean Notify(SimpleOrder orderDetails)
    {
        CustomerRepository customerRepository =new CustomerRepository();
        Customer customer = customerRepository.find(orderDetails.getCustomer());
        notification=new OrderNotification();


        notification.setNotificationTemplate();

        String notificationData= notification.getTemplateMessage();
        String products = "";
        for(int i=0;i<orderDetails.getProducts().size();i++)
        {
            products+=orderDetails.getProducts();
        }

        notificationData=notificationData.replace("{x}", orderDetails.getCustomer());
        notificationData=notificationData.replace("{y}",products);

        if(customer.getNotifyWith().size()==1)
        {
            if(customer.getNotifyWith().get(0) == ContactType.EMAIL.toString())
            {
                notification.setContactInfo(customer.getMail());
                notification.setContactType(ContactType.EMAIL);
            }
            else if (customer.getNotifyWith().get(0)== ContactType.SMS.toString()) {
                notification.setContactInfo(customer.getPhone());
                notification.setContactType(ContactType.SMS);
            }
        }
        else if (customer.getNotifyWith().size()==2)
        {
            notification.setContactInfo(customer.getMail());
            notification.setContactType(ContactType.EMAIL);
            this.save(notification);

            notification.setContactInfo(customer.getPhone());
            notification.setContactType(ContactType.SMS);
            this.save(notification);
        }

        return true;
    }

    @Override
    public NotificationTemplate getNotification()
    {
        NotificationTemplate notificationTemplate = notifications.get(this.id);
        notifications.remove(this.id);
        id--;
        return notificationTemplate;

    }

    @Override
    public HashMap<String, NotificationTemplate> listNotifications()
    {
        return notifications;
    }
    
}
