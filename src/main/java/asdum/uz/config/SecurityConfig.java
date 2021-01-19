//package asdum.uz.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.firewall.HttpFirewall;
//import org.springframework.security.web.firewall.StrictHttpFirewall;
////import asdum.uz.security.AuthService;
////import asdum.uz.security.JwtAuthenticationEntryPoint;
////import asdum.uz.security.JwtAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        securedEnabled = true,
//        jsr250Enabled = true,
//        prePostEnabled = true
//)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    AuthService authService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Autowired
////    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
////    }
//
//    @Bean
//    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowUrlEncodedSlash(true);
//        return firewall;
//    }
//
////    @Bean
////    @Override
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
//
////    @Bean
////    public JwtAuthenticationFilter jwtAuthenticationFilter() {
////        return new JwtAuthenticationFilter();
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf()
//                .disable()
//                .exceptionHandling()
////                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/",
//                        "/favicon.ico",
//                        "/**/*.png",
//                        "/**/*.gif",
//                        "/**/*.svg",
//                        ":5701/**",
//                        "localport=5701",
//                        "localport=5701/**",
//                        "/**/*.jpg",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js",
//                        "/swagger-ui.html",
//                        "/swagger-resources/**",
//                        "/v2/**",
//                        "/csrf",
//                        "/webjars/**")
//                .permitAll()
//                .antMatchers("/api/**", "/api/file", "localport=5701", "localport=5701/**", "/api/file/**", "/api/auth", "/api/auth/register", "/api/user/checkPhone", "/api/user/checkUser", "/api/user/setPassword")
//                .permitAll()
//                .antMatchers(HttpMethod.GET, "/api/file/**", "/api/file", "/api/category", "/api/auth/login", "/api/user/me", "/api/file/**")
//                .permitAll();
////                .antMatchers("/api/**")
////                .authenticated();
//
//        // Add our custom JWT security filter
////        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //@formatter:off
//
//        super.configure(web);
//        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
//    }
//}