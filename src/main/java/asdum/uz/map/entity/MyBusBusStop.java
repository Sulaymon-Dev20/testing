package asdum.uz.map.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MyBusBusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String nameLt;
    private String routes;
    private double lat;
    private double lng;
    private String status;
    private String route;
    @OneToMany
    private List<MyBusRoute> routeDataList;
}