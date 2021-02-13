package asdum.uz.map.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MyBusRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;
    private Double half;
    private Integer route_id;
    private String kpp1;
    private String kpp2;
    private String name;

    public MyBusRoute(Double total, Double half, Integer route_id, String kpp1, String kpp2, String name) {
        this.total = total;
        this.half = half;
        this.route_id = route_id;
        this.kpp1 = kpp1;
        this.kpp2 = kpp2;
        this.name = name;
    }
}