package com.opso.cheapshop.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "CheapShopExpApi")
    public OpenAPI bloggingOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("CheapShop Application API")
                        .description("CheapShop API implemented with Spring Boot RESTful service"));
    }

}