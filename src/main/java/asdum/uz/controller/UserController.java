//package asdum.uz.controller;
//
//import asdum.uz.config.CacheConfig;
//import asdum.uz.payload.ApiResponse;
//import asdum.uz.payload.ApiResponseModel;
//import asdum.uz.service.UserService;
//import com.fasterxml.jackson.databind.JsonNode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//    @Autowired
//    UserService usersService;
//    @Autowired
//    CacheConfig cacheConfig;
//
//    @PostMapping("/signUp")
//    public HttpEntity<?> signUp (@RequestBody JsonNode jsonNode, HttpServletRequest request){
//        String model = jsonNode.get("model").asText();
//        String secretKey =jsonNode.get("secretKey").asText();
//        if (secretKey != null && usersService.isSecretKeyValid(secretKey)) {
//            ApiResponse login = usersService.signUp(model);
//            return ResponseEntity.ok(login);
//        }
//        Map<String, String> status=new HashMap<>();
//        status.put("status", "101");
//        return ResponseEntity.ok(status);
//    }
//}
