package aamm.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.OrderRepository;
import aamm.order.model.CompundOrder;
import aamm.order.model.Order;
import aamm.order.model.SimpleOrder;
import aamm.order.model.Status;

@Service
public class CompundOrderService implements OrderService{
    @Autowired
    private SimpleOrderService simpleOrderService;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void placeOrder(Order order) {
        CompundOrder compundOrder = (CompundOrder) order;
        for (Order o : compundOrder.getOrders()) {
            simpleOrderService.placeOrder((SimpleOrder)o);
        }
        compundOrder.setStatus(Status.CONFIRMED);
        orderRepository.add(order);
    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.getOrder(id);
    }
    
}
