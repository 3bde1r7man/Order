package aamm.order.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.model.CompundOrder;
import aamm.order.model.Order;
import aamm.order.model.SimpleOrder;
import aamm.order.service.CompundOrderService;
import aamm.order.service.SimpleOrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private SimpleOrderService simpleOrderService;
    @Autowired
    private CompundOrderService compundOrderService;

    @PostMapping("/place-simple-order")
    public boolean placeSimpleOrder(@RequestBody SimpleOrder order) {
        if(order != null){
            simpleOrderService.placeOrder(order);
            return true;
        }
        return false;
    }
    
    @PostMapping("/place-compund-order")
    public boolean placeCompundOrder(@RequestBody CompundOrder order) {
        if(order != null){
            compundOrderService.placeOrder(order);
            return true;
        }
        return false;
    }

    @GetMapping("/get-order/{id}")
    public Order getOrder(@PathVariable int id) {
        return simpleOrderService.getOrder(id);
    }

    @GetMapping("/get-all-orders")
    public HashMap<Integer, Order> getAllOrders() {
        return simpleOrderService.getAllOrders();
    }
}
