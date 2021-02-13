package asdum.uz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaResponse {

    @JsonProperty(value = "gosNumber")
    private String gosNo;

    @JsonProperty(value = "busId")
    private Long busId;

    @JsonProperty(value = "remainingTime")
    private Long remainingTime;

    @JsonProperty(value = "remainingDistance")
    private Long remainingDistance;

    @JsonProperty(value = "regDateTime")
    private String regDateTime;

    @JsonProperty(value = "onOff")
    private Integer onOff;

    @JsonProperty(value = "location")
    private Object location;

/*    @JsonProperty(value = "polygonType")
    private Integer polygonType;*/

    @JsonProperty(value = "model")
    private String model;

    @JsonProperty(value = "modelNameInUz")
    private String modelNameInUz;

    @JsonProperty(value = "speed")
    private Integer speed;
}
