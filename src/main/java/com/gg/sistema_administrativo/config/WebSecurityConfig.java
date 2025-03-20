package com.gg.sistema_administrativo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // Permitir todas las peticiones sin autenticación
                )
                .csrf(csrf -> csrf.disable());  // Deshabilitar CSRF solo para un entorno de prueba (no recomendado para producción)
        return http.build();
    }
}

