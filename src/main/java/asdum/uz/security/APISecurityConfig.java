//package asdum.uz.security;
//
//
//import asdum.uz.repositroy.UserRepository;
//import asdum.uz.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//
//@Configuration
//@EnableWebSecurity
//@Order(1)
//public class APISecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Value("sfBBdk#6F5bc&u^a8&pHy#T9k")
//    private String principalRequestHeader;
//
//    @Value("sfBBdk#6F5bc&u^a8&pHy#T9k")
//    private String principalRequestValue;
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/api/signUp").permitAll().anyRequest().authenticated().and().exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
//        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader, userRepository);
//        filter.setAuthenticationManager(new AuthenticationManager() {
//
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//                String principal = (String) authentication.getPrincipal();
//
//                if (!principalRequestValue.equals(principal)) {
//                    throw new BadCredentialsException("The API key was not found or not the expected value.");
//                }
//                authentication.setAuthenticated(true);
//                return authentication;
//            }
//        });
//        httpSecurity.
//                antMatcher("/api/**").
//                csrf().disable().
//                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
//                and().addFilter(filter).authorizeRequests()
//                .anyRequest()
//                .authenticated();
//
//
//    }
//}