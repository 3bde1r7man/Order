package aamm.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.Repository.NotificationRepository;


@RestController
@RequestMapping("/ShipmentNotification")
public class ShipmentNotificationController {

    @GetMapping("/send")
    public Object sendNotification(@RequestParam NotificationRepository repo) throws InterruptedException {
        return  repo.getNotification();
    }

    @GetMapping("")
    public Object listNotifications(@RequestParam NotificationRepository repo) {
        return repo.listNotifications();
    }

}
