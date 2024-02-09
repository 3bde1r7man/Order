package aamm.order.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer { 
    @Id
    String name;
    String mail;
    String password;
    String phone;
    double balance;
    Location location;
    List<String> notifyWith;
}
