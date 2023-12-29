package aamm.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.OrderRepository;
import aamm.order.model.CompoundOrder;
import aamm.order.model.Order;
import aamm.order.model.SimpleOrder;
import aamm.order.model.Status;

@Service
public class CompoundOrderService implements OrderService{
    @Autowired
    private SimpleOrderService simpleOrderService;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean placeOrder(Order order) {
        CompoundOrder compoundOrder = (CompoundOrder) order;
        for (Order o : compoundOrder.getOrders()) {
            boolean response = simpleOrderService.placeOrder((SimpleOrder)o);
            if(!response){
                return false;
            }
        }
        compoundOrder.setStatus(Status.CONFIRMED);
        orderRepository.add(order);
        return true;
    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public boolean cancelOrder(int id) {
        CompoundOrder order = (CompoundOrder)orderRepository.getOrder(id);
        if(order.getStatus() == Status.CONFIRMED.toString() || order.getStatus() == Status.SHIPPED.toString()){
            order.setStatus(Status.CANCELLED);
            orderRepository.update(order);
            for (Order o : order.getOrders()) {
                simpleOrderService.cancelOrder(o.getId());
            }
            return true;
        }
        return false;
    }
    
}
