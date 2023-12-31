package aamm.order.service;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.OrderRepository;
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
        boolean response = customerService.deductBalance(simpleOrder.getCustomer(), simpleOrder.getTotal());
        if(!response){
            return false;
        }
        orderRepository.add(simpleOrder);
        return true;

    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public boolean cancelOrder(int id) {
        Order order = orderRepository.getOrder(id);
        if(order.getStatus() == Status.CONFIRMED.toString() || order.getStatus() == Status.SHIPPED.toString()){
            order.setStatus(Status.CANCELLED);
            orderRepository.update(order);
            return true;
        }
        return false;
    }

    public int changeStatus(int id, String status) {
        return orderRepository.changeStatus(id, status);
    }

    public HashMap<Integer, Order> getAllOrders() {
        return orderRepository.getOrders();
    }
}
