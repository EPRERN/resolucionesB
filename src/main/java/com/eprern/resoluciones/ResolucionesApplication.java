package com.eprern.resoluciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@SpringBootApplication
public class ResolucionesApplication {
	
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ResolucionesApplication.class, args);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("||                                          ||");
		System.out.println("||            Iniciando Aplicación 🚀       ||");
		System.out.println("||                                          ||");
		System.out.println("||        Hecha por: Lautaro Avila          ||");
		System.out.println("||                                          ||");
		System.out.println("==============================================");
		
	}
	
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("http://192.168.2.210:4200") // origen de Angular
//						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//						.allowedHeaders("*")
//						.allowCredentials(true);
//			}
//		};
//	}

}
