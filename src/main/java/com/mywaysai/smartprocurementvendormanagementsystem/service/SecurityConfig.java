package com.mywaysai.smartprocurementvendormanagementsystem.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/vendors/**").hasRole("ADMIN")
//                .requestMatchers("/requisitions/**").hasRole("EMPLOYEE")
//                .requestMatchers("/approvals/**").hasRole("MANAGER")
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }









//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/roles/**").permitAll()   // ✅ allow roles
//                        .requestMatchers("/vendors/**").hasRole("ADMIN")
//                        .requestMatchers("/requisitions/**").hasRole("EMPLOYEE")
//                        .requestMatchers("/approvals/**").hasRole("MANAGER")
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }


}

