package aamm.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.Repository.NotificationRepository;
import aamm.order.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import aamm.order.service.OrderNotifcationService;

@RestController
@RequestMapping("/orders/notification")
public class OrderNotificationController {
    @Autowired
    private OrderNotifcationService service;

    @GetMapping("")
    public Object listNotifications() {
        return service.listNotifications();
    }

}
