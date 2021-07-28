package com.eiv.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerCfg {

    @Bean
    public OpenAPI springOpenApi() {

        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Prueba Blaze Persistence")
                .description("Aplicación para probar Blaze Persistence con Spring")
                .version("1"));
    }

}
