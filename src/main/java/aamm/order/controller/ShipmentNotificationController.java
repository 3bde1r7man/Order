package aamm.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.Repository.NotificationRepository;
import aamm.order.service.NotificationService;
import aamm.order.service.ShipmentNotificationService;

@RestController
@RequestMapping("/shipments/notification")
public class ShipmentNotificationController {

    @Autowired
    private ShipmentNotificationService service;

    @GetMapping("")
    public Object listNotifications() {
        return service.listNotifications();
    }

}
