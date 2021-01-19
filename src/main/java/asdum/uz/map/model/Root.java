package asdum.uz.map.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    String status;
    BusStop aPoint;
    BusStop bPoint;
    Object routs;
    List<Object> direction;
    Double distanceA;
    Double distance;
    Double distanceB;
}
