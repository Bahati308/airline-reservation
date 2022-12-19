package com.insidercloud.airlinereservation;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {

    private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> {
                    try {
                        authorize
                                        .requestMatchers("/","/images/**").permitAll()
                                        .anyRequest().authenticated()
                                        .and().oauth2Login()
                                        .and().logout()
                                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                        .addLogoutHandler(logoutHandler);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                );
        return http.build();
    }
}