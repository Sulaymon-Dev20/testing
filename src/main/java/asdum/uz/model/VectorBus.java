package asdum.uz.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VectorBus implements Serializable {
    private String input_time;
    private Date time;
    private Long busID;
    private Integer reyscount;
    private String gos_no;
    private Integer side;
    private Integer prosent;
    private Integer onoff;
    private Long m;
    private Double int_km;
    private Integer int_min;
    private Double mileage;
    private Integer polygonType;
    private Long prostoy;
    private String stationName;
    private Integer speed;
    private String model;
    private String modelNameInUz;
    private Integer stopType;
}
