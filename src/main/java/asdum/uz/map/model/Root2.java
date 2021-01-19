package asdum.uz.map.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Root2 {
    BusStop aPoint;
    BusStop bPoint;
    List<String> routs;
    Double distanceA;
    Double distance;
    Double distanceB;
}
