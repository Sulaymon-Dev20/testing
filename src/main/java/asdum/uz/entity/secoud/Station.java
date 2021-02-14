package asdum.uz.entity.secoud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Station {
    @Id
    private long id;
    private Double lat;
    private Double lng;

    @OneToMany
    private List<RouteBus> routeBusList;
}
