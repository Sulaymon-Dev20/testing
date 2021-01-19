package asdum.uz.payload;

import asdum.uz.entity.enums.ResStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseModel {
    private ResStatusEnum success;
    private String message;
    private Object object;

    public ApiResponseModel(ResStatusEnum success, String message) {
        this.success = success;
        this.message = message;
    }
}
