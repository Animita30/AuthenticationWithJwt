package com.example_ecom.demo5_1.configuration;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    //added this after watching the youtube video by Coding Streams
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    public SecurityConfig(AuthenticationEntryPoint authenticationEntryPoint, JWTAuthenticationFilter jwtAuthenticationFilter){
        this.authenticationEntryPoint=authenticationEntryPoint;
        this.jwtAuthenticationFilter=jwtAuthenticationFilter;
    }
    //till here

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
//
//            return configuration.getAuthenticationManager();
//    }


//@Bean
//public AuthenticationManager authenticationManager() throws Exception {
//    return super.authenticationManagerBean();
//}
//@Bean
//public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
//    return builder.getAuthenticationManager();
//}

    @Bean //this was used for plain login and registration without spring security interfereing here
    /*public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       
        //http.cors(AbstractHttpConfigurer::disable);
        http.cors(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        
        //http.authorizeHttpRequests(auth->auth.requestMatchers("/api/user/register")
        //        .permitAll().anyRequest().authenticated()).formLogin(AbstractHttpConfigurer::disable).httpBasic(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(requestMatcher ->
                        requestMatcher.requestMatchers("/api/user/register").permitAll().requestMatchers("api/user/login").permitAll().anyRequest().authenticated())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //http.build();
        

        return http.build();

    }*/

    //the below SecurityFilterChain is created using JWT authentication using the youtube video of Coding Streams
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //disable cors
        httpSecurity.cors(AbstractHttpConfigurer::disable);
        //disable csrf
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        //http request filter
        httpSecurity.authorizeHttpRequests(auth->auth.requestMatchers("/api/user/register").permitAll().requestMatchers("api/user/login").permitAll().anyRequest().authenticated());
        //authentication entry point- exception handler
        httpSecurity.exceptionHandling(exceptionConfig->exceptionConfig.authenticationEntryPoint(authenticationEntryPoint));
        //set session policy =STATELESS
        httpSecurity.sessionManagement(sessionConfig->sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //Add JWT Authentication Filter
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();




    }


}
