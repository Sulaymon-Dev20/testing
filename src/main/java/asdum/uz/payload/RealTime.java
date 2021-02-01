package asdum.uz.payload;

import asdum.uz.model.ViaResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealTime {
    private Object route;
    private Object station;
    private List<ViaResponse> list;
}
