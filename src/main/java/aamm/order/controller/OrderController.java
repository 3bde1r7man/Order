package aamm.order.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.config.JsonUtil;
import aamm.order.model.CompoundOrder;
import aamm.order.model.Order;
import aamm.order.model.SimpleOrder;
import aamm.order.service.CompoundOrderService;
import aamm.order.service.SimpleOrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private SimpleOrderService simpleOrderService;
    @Autowired
    private CompoundOrderService compoundOrderService;

    @PostMapping("/place/simple-order")
    public Object placeSimpleOrder(@RequestBody SimpleOrder order) {
        if(order != null){
            boolean response = simpleOrderService.placeOrder(order);
            if (response) {
                return JsonUtil.success("Order placed successfully");
            }
            JsonUtil.error("Order not placed");
        }
        return JsonUtil.error("Order not placed");
    }
    
    @PostMapping("/place/compound-order")
    public Object placecompoundOrder(@RequestBody CompoundOrder order) {
        if(order != null){
            boolean response = compoundOrderService.placeOrder(order);
            if (response) {
                return JsonUtil.success("Order placed successfully");
            }
            JsonUtil.error("Order not placed");
        }
        return JsonUtil.error("Order not placed");
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return simpleOrderService.getOrder(id);
    }

    @GetMapping("")
    public HashMap<Integer, Order> getAllOrders() {
        return simpleOrderService.getAllOrders();
    }

    @PutMapping("/cancel/simple-order/{id}")
    public Object cancelSimpleOrder(@PathVariable int id) {
        boolean respone =  simpleOrderService.cancelOrder(id);
        if (!respone) {
            return JsonUtil.error("Order not cancelled");
        }
        return JsonUtil.success("Order cancelled successfully");
    }

    @PutMapping("/cancel/compound-order/{id}")
    public Object cancelcompoundOrder(@PathVariable int id) {
        boolean respone =  compoundOrderService.cancelOrder(id);
        if (!respone) {
            return JsonUtil.error("Order not cancelled");
        }
        return JsonUtil.success("Order cancelled successfully");
        }

    @PutMapping("/change-status/{id}/{status}") // the admin can change the status of the order 
    public Object changeStatus(@PathVariable int id, @PathVariable String status) {
        int response = simpleOrderService.changeStatus(id, status);
        if (response == -1) {
            return JsonUtil.error("Order status already on intended status");
        }
        if (response == 0) {
            return JsonUtil.error("Order status cannot be changed");
        }
        return JsonUtil.success("Order status changed successfully");
    }
}
