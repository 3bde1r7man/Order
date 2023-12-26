package aamm.order.model;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class CompundOrder extends Order {
    List<Order> orders;
    
    
    @Override
    public void placeOrder(Order order) {
        CompundOrder compundOrder = (CompundOrder) order;
        for (Order o : compundOrder.orders) {
            o.placeOrder(o);
        }

    }
    @Override
    public double getTotal() {
        return 0;
    }
}
