package org.shiv.jwtauth.configuration;

import org.shiv.jwtauth.security.JWTAuthenticationFilter;
import org.shiv.jwtauth.security.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.AuthorizeHttpRequestsDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(csrf-> csrf.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/home/**").authenticated()
                        .requestMatchers("/auth/login")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex->ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(session->session .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.addFilterAt(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
