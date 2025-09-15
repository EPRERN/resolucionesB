package com.eprern.resoluciones.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable)
				.cors(withDefaults())    // usamos el bean corsConfigurationSource()
				.authorizeHttpRequests(auth -> auth
						.anyRequest().permitAll()
				);
		return http.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration cors = new CorsConfiguration();
		
		// Lista de orígenes confiables
		cors.setAllowedOrigins(List.of(
				"http://192.168.2.210:4200", // 👈 frontend Angular en red local
				"http://localhost:4200",     // 👈 para pruebas locales
				"http://192.168.2.210"     // 👈 dominio real en producción
		));
		
		// Métodos HTTP permitidos
		cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		
		// Cabeceras permitidas
		cors.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With"));
		
		// Soporte para cookies / credenciales
		cors.setAllowCredentials(true);
		
		// Tiempo de cacheo de la configuración preflight en el navegador
		cors.setMaxAge(3600L);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", cors);
		return source;
	}
	
	
	
}



