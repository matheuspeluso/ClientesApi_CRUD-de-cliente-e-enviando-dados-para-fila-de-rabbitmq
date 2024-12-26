package br.com.cotiinformatica.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
@Configuration
public class SwaggerConfig {
	@Bean
	OpenAPI customOpenApi() {
		OpenAPI openAPI = new OpenAPI()
				.components(new Components().addSecuritySchemes("bearerAuth",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
				.info(new Info().title("clientesAPI - API RESTful para controle de clientes.")
						.description("Projeto Final do curso Java WebDeveloper - Formação Fullstack.").version("v1")
						.contact(new Contact().name("Dev Matheus Peluso").email("matheuspeluso17@gmail.com")
								.url("https://www.linkedin.com/in/devmatheuspeluso/"))
						.license(new License().name("MIT License").url("https://opensource.org/licenses/MIT")))
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
		return openAPI;
	}
}