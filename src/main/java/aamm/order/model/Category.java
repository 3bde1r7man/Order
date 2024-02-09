package aamm.order.model;

import java.util.HashMap;
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
public class Category {
    @Id
    private String slug;
}
