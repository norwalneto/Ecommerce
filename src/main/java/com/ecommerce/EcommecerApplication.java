package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ecommerce.config.OpenApiServerProperties;

@SpringBootApplication
@EnableConfigurationProperties(OpenApiServerProperties.class)
public class EcommecerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommecerApplication.class, args);
	}

}
