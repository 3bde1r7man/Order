package aamm.order.service;
import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//import aamm.order.Repository.OrderNotificationRepository;
//import aamm.order.Repository.ShipmentNotificatioRepository;

@Service
public class EmailNotificationService extends BaseNotificationService {
    String message=" Sent by E-mail";
    NotificationService notification;
    public EmailNotificationService(NotificationService notifier) {
        super(notifier);
    }
    public EmailNotificationService(){}
    @Override 
   // @Async
    public Object sendNotification() throws InterruptedException {
        wait(40);
        return notification.sendNotification() + message;
    }


}
