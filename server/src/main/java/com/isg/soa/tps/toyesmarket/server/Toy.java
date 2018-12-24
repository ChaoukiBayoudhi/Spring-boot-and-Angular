package com.isg.soa.tps.toyesmarket.server;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "toy")
public class Toy {
    @Id @GeneratedValue
    private Long code;
    private @NonNull String name;
    private @NonNull String type;
    private Integer minAge;
    private Integer maxAge;
    private Double price;

    public Toy(String name, String type, Integer minAge, Integer maxAge, Double price) {
        this.name = name;
        this.type = type;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.price = price;
    }
}
