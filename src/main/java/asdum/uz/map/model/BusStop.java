package asdum.uz.map.model;

import asdum.uz.map.model.enums.BusStopStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusStop {
    // Attributes --------------------------------------------------------
    private long id;
    private String name;
    private String routes;
    private double lat;
    private double lng;
    private String status;
    private String route;
    // Constructor(s) ----------------------------------------------------
    public BusStop() {
        super();
    }
    // Miscellaneous -----------------------------------------------------
    public BusStopStatusEnum getStatusEnum() {
        return BusStopStatusEnum.getFromStringValue(status);
    }
    // -------------------------------------------------------------------
}
