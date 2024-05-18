package com.craft.LeadManagementService.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class SwaggerOpenApiDoc {
	
	@Bean
	public OpenAPI openAPI() {
		
		return new OpenAPI().info(new Info()
				.title("LeadManagementService API")
				.version("1.2")
				.description("This is Lead Management Service Api")
				.contact(new Contact()
				.name("Ashenafi C")
				.email("kingMenelik@gmail.com")));
	}

}
