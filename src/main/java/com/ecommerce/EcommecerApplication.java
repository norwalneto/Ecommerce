package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ecommerce.config.OpenApiServerProperties;

@SpringBootApplication
@EnableConfigurationProperties(OpenApiServerProperties.class)
public class EcommecerApplication {

	public static void main(String[] args) {
		System.out.println("Iniciando aplicação...");
        System.out.println("Variáveis:");
        System.out.println("PORT: " + System.getenv("PORT"));
        System.out.println("DB: " + System.getenv("MYSQLHOST"));
		SpringApplication.run(EcommecerApplication.class, args);
	}

}
