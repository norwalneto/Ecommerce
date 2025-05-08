package com.ecommerce.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {
    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.contact.name}")
    private String contactName;

    @Value("${info.contact.email}")
    private String contactEmail;

    @Value("${info.license.name}")
    private String licenseName;

    @Value("${info.license.url}")
    private String licenseUrl;

    @Value("${openapi.servers[0].url}")
    private String devServerUrl;

    @Value("${openapi.servers[0].description}")
    private String devServerDesc;

    @Value("${openapi.servers[1].url}")
    private String prodServerUrl;

    @Value("${openapi.servers[1].description}")
    private String prodServerDesc;

    @Bean
    public OpenAPI customOpenAPI() {
        // Esquema de segurança JWT
        SecurityScheme bearerScheme = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .description("Use o header Authorization: Bearer <token>");

        // Lista de servidores (Dev e Prod)
        List<Server> servers = List.of(
            new Server().url(devServerUrl).description(devServerDesc),
            new Server().url(prodServerUrl).description(prodServerDesc)
        );

        return new OpenAPI()
            .info(new Info()
                .title(appName)
                .version(appVersion)
                .description(appDescription)
                .contact(new Contact().name(contactName).email(contactEmail))
                .license(new License().name(licenseName).url(licenseUrl))
            )
            .servers(servers)
            .components(new Components().addSecuritySchemes("bearerAuth", bearerScheme))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            // Tags globais
            .addTagsItem(new Tag().name("Usuários").description("Gerenciamento de usuários"));
    }

}
