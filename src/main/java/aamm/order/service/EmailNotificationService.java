package aamm.order.service;
//import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import aamm.order.Repository.NotificationRepository;
//import aamm.order.Repository.OrderNotificationRepository;
//import aamm.order.Repository.ShipmentNotificatioRepository;

@Service
public class EmailNotificationService extends BaseNotificationService {
    String message=" Sent by E-mail";
    public EmailNotificationService(NotificationService notifier) {
        super(notifier);
    }

    @Override 
    public Object sendNotification(NotificationRepository notification) throws InterruptedException {
        return notification.getNotification() + message;
    }

}
