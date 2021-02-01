package asdum.uz.map.model;

import asdum.uz.map.model.enums.BusStopStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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
//    private String[] routeList;
//    private List<Long> routeIdList;
//    private List<Route> routeDataList;
    private List<Map<String, Object>> routeDataList;

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

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Route {
    private Double total;
    private Double half;
    private Double app_type;
    private Integer route_id;
    private String kpp1;
    private String kpp2;
    private String name;
}