package aamm.order.Repository;

import java.util.HashMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aamm.order.model.NotificationTemplate;
import aamm.order.model.SimpleOrder;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationTemplate, String>{
    public boolean Notify(SimpleOrder orderDetails);
    public NotificationTemplate getNotification()throws InterruptedException;
    public HashMap<String, NotificationTemplate> listNotifications();
}
