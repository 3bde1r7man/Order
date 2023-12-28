package aamm.order.service;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Simple;
import org.springframework.stereotype.Service;

import aamm.order.Repository.OrderRepository;
import aamm.order.model.Order;
import aamm.order.model.SimpleOrder;
import aamm.order.model.Status;

@Service
public class SimpleOrderService implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void placeOrder(Order order) {
        SimpleOrder simpleOrder = (SimpleOrder) order;
        simpleOrder.setStatus(Status.CONFIRMED);
        orderRepository.add(simpleOrder);
    }
    @Override
    public Order getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public HashMap<Integer, Order> getAllOrders() {
        return orderRepository.getOrders();
    }
}
