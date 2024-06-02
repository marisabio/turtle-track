package com.turtle.track.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI gerarDocumentacao() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.description("URL de desenvolvimento local.");

        Contact contact = new Contact();
        contact.setEmail("mariana.msabio@gmail.com");
        contact.setName("Mariana");
        Info  info = new Info().title("Turtle Track")
                .version("0.1")
                .contact(contact)
                .description("Documentação de API do Turtle Track.");
        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
