package com.training.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI publicApi() {
        final Info info = new Info().title("App service API")
                .description("Provides API for App service read/write operations")
                .contact(getContactInfo())
                .version("v1");
        return new OpenAPI().info(info);
    }

    private Contact getContactInfo() {
        final Contact contact = new Contact();
        contact.setName("Sunrise Assurant");
        contact.setEmail("sunriseassurant@gmail.com");
        return contact;
    }
}
