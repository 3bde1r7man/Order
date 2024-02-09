package aamm.order.Repository;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import aamm.order.model.ContactType;
import aamm.order.model.Customer;
import aamm.order.model.NotificationTemplate;
import aamm.order.model.ShipmentNotification;
import aamm.order.model.SimpleOrder;

@Repository
@Primary
public class ShipmentNotificatioRepository implements NotificationRepository {
    static HashMap<String, NotificationTemplate> notifications = new HashMap<String,NotificationTemplate>();
    
    ShipmentNotification notification;

    long id = 1;

    
    public void save(NotificationTemplate notificationTemplate) {
        notificationTemplate.setId(id++);
        notifications.put(notificationTemplate.getContactInfo(), notificationTemplate);
        
    }
    @Override
    public boolean Notify(SimpleOrder orderDetails)
    {
        CustomerRepository customerRepository =new CustomerRepositoryInMem();
        Customer customer = customerRepository.find(orderDetails.getCustomer());
        notification=new ShipmentNotification();

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
            if(customer.getNotifyWith().get(0).equals(ContactType.EMAIL.toString()))
            {
                notification.setContactInfo(customer.getMail());
                notification.setContactType(ContactType.EMAIL);
            }
            else if (customer.getNotifyWith().get(0).equals(ContactType.SMS.toString())) {
                notification.setContactInfo(customer.getPhone());
                notification.setContactType(ContactType.SMS);
            }
            notification.setTemplateMessage(notificationData);
            this.save(notification);
        }
        else if (customer.getNotifyWith().size()==2)
        {

            notification.setContactInfo(customer.getMail());
            notification.setContactType(ContactType.EMAIL);
            notification.setTemplateMessage(notificationData);
            this.save(notification);
            ShipmentNotification notification2 = new ShipmentNotification();
            notification2.setContactInfo(customer.getPhone());
            notification2.setContactType(ContactType.SMS);
            notification2.setTemplateMessage(notificationData);
            this.save(notification2);
        }
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
        return notifications;
    }

}
