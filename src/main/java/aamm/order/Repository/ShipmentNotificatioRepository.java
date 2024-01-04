package aamm.order.Repository;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.management.Notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import aamm.order.config.JsonUtil;
import aamm.order.model.ContactType;
import aamm.order.model.Customer;
import aamm.order.model.NotificationTemplate;
import aamm.order.model.OrderNotification;
import aamm.order.model.ShipmentNotification;
import aamm.order.model.SimpleOrder;
@Repository
@Service
@Primary
public class ShipmentNotificatioRepository implements NotificationRepository {
    public static HashMap<String, NotificationTemplate> notifications = new HashMap<String,NotificationTemplate>();
    ShipmentNotification notification ;

    long id = 1;

    
    public void save(NotificationTemplate notificationTemplate) {
        notificationTemplate.setId(id++);
        System.out.println("inside save" );
        notifications.put(notificationTemplate.getContactInfo(), notificationTemplate);
        
    }
    @Override
    public boolean Notify(SimpleOrder orderDetails)
    {
        CustomerRepository customerRepository =new CustomerRepository();
        Customer customer = customerRepository.find(orderDetails.getCustomer());
        this.notification = new ShipmentNotification();

        this.notification.setNotificationTemplate();

        String notificationData= this.notification.getTemplateMessage();
        String products = "";
        for(int i=0;i<orderDetails.getProducts().size();i++)
        {
            products+=orderDetails.getProducts();
        }
        System.out.println("customer" + orderDetails.getCustomer());
        
        notificationData=notificationData.replace("{X}", orderDetails.getCustomer());
        notificationData=notificationData.replace("{y}",products);
        this.notification.setNotificationTemplate(notificationData);
        System.out.println("Notification data: " + notificationData);

        if(customer.getNotifyWith().size()==1)
        {
            if(customer.getNotifyWith().get(0).equals(ContactType.EMAIL.toString()))
            {
                this.notification.setContactInfo(customer.getMail());
                this.notification.setContactType(ContactType.EMAIL);
            }
            else if (customer.getNotifyWith().get(0).equals(ContactType.SMS.toString())) {
                this.notification.setContactInfo(customer.getPhone());
                this.notification.setContactType(ContactType.SMS);
            }
            this.save(this.notification);
        }
        else if (customer.getNotifyWith().size()==2)
        {
            this.notification.setContactInfo(customer.getMail());
            this.notification.setContactType(ContactType.EMAIL);
            this.save(this.notification);

            this.notification.setContactInfo(customer.getPhone());
            this.notification.setContactType(ContactType.SMS);
            this.save(this.notification);
        }
        System.out.println("Notification asdasdasda: " + this.notification.toString());
        System.out.println("Notification sent to "+customer.getName()+" with "+customer.getNotifyWith().toString());
        System.out.println("Notificationsssssssssss data: " + notifications.toString());
        return true;
    }

    @Override
    public NotificationTemplate getNotification() throws InterruptedException
    {
        NotificationTemplate notificationTemplate = notifications.get(this.id);
        notifications.remove(this.id);
        id--;
        return notificationTemplate;

    }

    @Override
    public HashMap<String, NotificationTemplate> listNotifications()
    {
        System.out.println("Notificationsssssssssss data: " + notifications.toString());
        return notifications;
    }

}
