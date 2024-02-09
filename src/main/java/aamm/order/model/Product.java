package aamm.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    private String serialNumber;
    private String name;
    private double price;
    private String vendor;
    private String category;
}
