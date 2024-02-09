package aamm.order.model;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Order {
    @Id
    protected int id;
    protected String customer;
    protected double fees;
    protected Status status;

    public abstract double getTotal();

}
