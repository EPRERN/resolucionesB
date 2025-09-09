package com.eprern.resoluciones.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable) // desactiva CSRF
				.cors(cors -> cors.configurationSource(request -> {
					var corsConfig = new CorsConfiguration();
					corsConfig.setAllowedOrigins(List.of("http://localhost:4200")); // Angular
					corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
					corsConfig.setAllowedHeaders(List.of("*"));
					corsConfig.setAllowCredentials(true);
					return corsConfig;
				}))
				.authorizeHttpRequests(auth -> auth
						.anyRequest().permitAll() // 🔹 permite todas las rutas mientras desarrollás
				);
		return http.build();
	}
	
}