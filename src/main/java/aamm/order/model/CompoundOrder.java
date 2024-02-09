package aamm.order.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CompoundOrder extends Order {
    private List<SimpleOrder> orders;
    
    
    // @Override
    // public void placeOrder(Order order) {
    //     compoundOrder compoundOrder = (compoundOrder) order;
    //     for (Order o : compoundOrder.orders) {
    //         o.placeOrder(o);
    //     }
    // }

    public CompoundOrder(List<SimpleOrder> orders, Status status, int id, String customer, double fees) {
        this.id = id;
        this.customer = customer;
        this.fees = fees;
        this.orders = orders;
        this.status = status;
    }

    public List<SimpleOrder> getOrders() {
        return orders;
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (Order o : orders) {
            total += o.getTotal();
        }
        return total;
    }


}
