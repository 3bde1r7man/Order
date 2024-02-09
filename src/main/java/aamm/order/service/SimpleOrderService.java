package aamm.order.service;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.OrderNotificationRepository;
import aamm.order.Repository.OrderRepository;
import aamm.order.Repository.ShipmentNotificatioRepository;
import aamm.order.model.Order;
import aamm.order.model.SimpleOrder;
import aamm.order.model.Status;

@Service
public class SimpleOrderService implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CustomerService customerService;
    
    
    @Override
    public boolean placeOrder(Order order) {
        SimpleOrder simpleOrder = (SimpleOrder) order;
        simpleOrder.setStatus(Status.CONFIRMED);
        if(simpleOrder.getFees() == 0){
            simpleOrder.setFees(randomFees(10, 200));
        }
        boolean response = customerService.deductBalance(simpleOrder.getCustomer(), simpleOrder.getTotal());
        if(!response){
            return false;
        }
        orderRepository.save(simpleOrder);
        OrderNotificationRepository notify = new OrderNotificationRepository();
        notify.Notify(simpleOrder);
        ShipmentNotificatioRepository shipmentNotify = new ShipmentNotificatioRepository();
        shipmentNotify.Notify(simpleOrder);
        return true;
    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public boolean cancelOrder(int id) {
        SimpleOrder order = (SimpleOrder)orderRepository.findById(id).get();
        if(order.getStatus().equals(Status.CONFIRMED.toString()) || order.getStatus().equals(Status.SHIPPED.toString())){
            order.setStatus(Status.CANCELLED);
            orderRepository.save(order);
            ShipmentNotificatioRepository shipmentNotify = new ShipmentNotificatioRepository();
            shipmentNotify.Notify(order);

            return true;
        }
        return false;
    }

    public int changeStatus(int id, String status) {
        SimpleOrder order = (SimpleOrder)orderRepository.findById(id).get();
        ShipmentNotificatioRepository shipmentNotify = new ShipmentNotificatioRepository();
        shipmentNotify.Notify(order);
        if(order.getStatus().equals(status)){
            return -1;
        }
        if((order.getStatus().equals(Status.CANCELLED.toString()) || order.getStatus().equals(Status.DELIVERED.toString())) && (!status.equals(Status.CANCELLED.toString()) && !status.equals(Status.DELIVERED.toString()))){
            return 0;
        }
        order.setStatus(Status.fromString(status));
        orderRepository.save(order);
        return 1;
    }

    public Object getAllOrders() {
        return orderRepository.findAll();
    }


    public int randomFees(int min, int max){
        return  (int) (Math.random() * (max - min + 1) + min);
    }
}
