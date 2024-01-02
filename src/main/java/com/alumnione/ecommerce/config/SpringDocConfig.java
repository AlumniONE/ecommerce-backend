package com.alumnione.ecommerce.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
        .info(new Info().title("eCommerce API")
        .description("Spring eCommerce Sample Application")
        .version("v0.0.1")
        /*.license(new License().name("Apache 2.0").url("http://springdoc.org"))*/)
        .externalDocs(new ExternalDocumentation()
        .description("eCommerce GitHub")
        .url("https://github.com/AlumniONE/ecommerce-backend"));
    }
}
