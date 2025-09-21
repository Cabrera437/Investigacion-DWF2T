package com.openapi.sample_openapi.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion){
     return new OpenAPI().components(new Components())
                .info(new Info().title("Saludos personalizados  API").version(appVersion)
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(new Contact().email("hello@gmail.com").url("http://example.com").name("Elaniin")));



    }

}
