package asdum.uz.map.metro;

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
//@Document(collation = "metro")
@Entity
public class MetroStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String routes;
    private String tunnels;
    private String status;
    private String route;

    public MetroStop(String name, String routes, String tunnels, String status, String route) {
        this.name = name;
        this.routes = routes;
        this.tunnels = tunnels;
        this.status = status;
        this.route = route;
    }
}
