package asdum.uz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse{
    private String message;
    private Object accessToken;
    private Object refreshToken;
}
