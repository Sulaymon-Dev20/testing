package asdum.uz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by root on 11/26/14.
 */
@Data
public class ViaResponse {

    @JsonProperty(value = "g")
    private String gosNo;

    @JsonProperty(value = "b")
    private Long busId;

    @JsonProperty(value = "t")
    private Long remainingTime;

    @JsonProperty(value = "d")
    private Long remainingDistance;

    @JsonProperty(value = "r")
    private String regDateTime;

    @JsonProperty(value = "i")
    private Integer onOff;

    @JsonProperty(value = "p")
    private Integer polygonType;

    @JsonProperty(value = "m")
    private String model;

    @JsonProperty(value = "m_uz")
    private String modelNameInUz;

    @JsonProperty(value = "s")
    private Integer speed;

}
