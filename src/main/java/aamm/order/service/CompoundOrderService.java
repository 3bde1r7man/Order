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
        compoundOrder.setFees(simpleOrderService.randomFees(10, 1000));
        int size = compoundOrder.getOrders().size();
        double feesForEach = compoundOrder.getFees()/size;
        for (Order o : compoundOrder.getOrders()) {
            o.setFees(feesForEach);
            boolean response = simpleOrderService.placeOrder((SimpleOrder)o);
            if(!response){
                return false;
            }
        }
        compoundOrder.setStatus(Status.CONFIRMED);
        orderRepository.save(order);
        return true;
    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public boolean cancelOrder(int id) {
        CompoundOrder order = (CompoundOrder)orderRepository.findById(id).get();
        if(order.getStatus().equals(Status.CONFIRMED.toString())|| order.getStatus().equals(Status.SHIPPED.toString())){
            order.setStatus(Status.CANCELLED);
            orderRepository.save(order);
            for (Order o : order.getOrders()) {
                simpleOrderService.cancelOrder(o.getId());
            }
            return true;
        }
        return false;
    }
    
}
