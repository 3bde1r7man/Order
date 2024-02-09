package aamm.order.model;

import org.springframework.stereotype.Component;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Location {
    String nation;
    String city;
    String section;
    String street;
}
