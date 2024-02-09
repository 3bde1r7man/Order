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
public class SimpleOrder extends Order {

    private List<Product> products;
    private double totalPrice;
    
    // @Override
    // public void placeOrder(Order order) {
    //     // do nothing
    // }

    @Override
    public double getTotal() {
        return totalPrice + fees;
    }



}
