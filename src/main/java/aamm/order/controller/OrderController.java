package aamm.order.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.model.CompoundOrder;
import aamm.order.model.Order;
import aamm.order.model.SimpleOrder;
import aamm.order.model.Status;
import aamm.order.service.CompoundOrderService;
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
    private CompoundOrderService compoundOrderService;

    @PostMapping("/place-simple-order")
    public boolean placeSimpleOrder(@RequestBody SimpleOrder order) {
        if(order != null){
            simpleOrderService.placeOrder(order);
            return true;
        }
        return false;
    }
    
    @PostMapping("/place-compound-order")
    public boolean placecompoundOrder(@RequestBody CompoundOrder order) {
        if(order != null){
            compoundOrderService.placeOrder(order);
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

    @PostMapping("/cancel/simple-order/{id}")
    public boolean cancelSimpleOrder(@PathVariable int id) {
        return simpleOrderService.cancelOrder(id);
    }

    @PostMapping("/cancel/compound-order/{id}")
    public boolean cancelcompoundOrder(@PathVariable int id) {
        return compoundOrderService.cancelOrder(id);
    }

    @PostMapping("/change-status/{id}/{status}") // the admin can change the status of the order 
    public boolean changeStatus(@PathVariable int id, @PathVariable String status) {
        simpleOrderService.changeStatus(id, status);
        return true;
    }
}
