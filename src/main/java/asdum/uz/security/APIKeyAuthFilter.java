//package asdum.uz.security;
//
//import asdum.uz.entity.enums.User;
//import asdum.uz.repositroy.UserRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ResponseStatusException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Base64;
//
//public class APIKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {
//
//    private String principalRequestHeader;
//    private  final UserRepository userRepository;
//
//
//    public APIKeyAuthFilter(String principalRequestHeader, UserRepository userRepository) {
//        this.principalRequestHeader = principalRequestHeader;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
//        String header = request.getHeader("secretKey");
//        if (StringUtils.hasText(header)){
//            String s = new String(Base64.getMimeDecoder().decode(header));
//            String secretKey = s.substring(0,25);
//            String sid = s.substring(25, s.length());
//            User user = null;
//                 user = userRepository.findBySid(sid).get();
//
//            if (user == null){
//               throw new BadCredentialsException("The API key was not found or not the expected value.");
//           }
//
//            return secretKey;
//        }
//       return null;
//    }
//
//    @Override
//    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
//        return "N/A";
//    }
//
//    public User loadUserById(String sid) {
//        try {
//            return userRepository.findBySid(sid).get();
//        } catch (Exception ex) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "User not found",ex);
//        }
//    }
//
//
//
//
//}
