//package asdum.uz.service;
//import asdum.uz.entity.enums.User;
//import asdum.uz.payload.ApiResponse;
//import asdum.uz.payload.ApiResponseModel;
//import asdum.uz.repositroy.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import javax.servlet.http.HttpServletRequest;
//import java.math.BigInteger;
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Base64;
//import java.util.Date;
//import java.util.UUID;
//
//@Service
//public class UserService  {
//    @Autowired
//    UserRepository userRepository;
//
//    public boolean isSecretKeyValid(String secretKey) {
//        return "lswk&JSyIqol#5SEtZ6@S$@7".equals(secretKey);
//    }
//
//    public ApiResponse signUp(String model) {
//        String sid = String.valueOf(UUID.randomUUID());
//        Date expiryDate = Date.from(LocalDateTime.now().plusDays(3).atZone(ZoneId.systemDefault()).toInstant());
//        String key = "sfBBdk#6F5bc&u^a8&pHy#T9k";
//        String s = key + expiryDate.getTime() + sid;
//        userRepository.save(new User(model, sid, new Date()));
//        return new ApiResponse("success",new String(Base64.getEncoder().encode(s.getBytes())), refreshKey(sid));
//    }
//
//
//    public String refreshKey(String sid) {
//        String key = "sfBBdk#6F5bc&u^a8&pHy#T9k";
//        String s = key + sid;
//        return new String(Base64.getEncoder().encode(s.getBytes()));
//    }
//
//
//    public static String getSHA512(String input) {
//
//        String toReturn = null;
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-512");
//            digest.reset();
//            digest.update(input.getBytes(StandardCharsets.UTF_8));
//            toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return toReturn;
//    }
//
//
//}
