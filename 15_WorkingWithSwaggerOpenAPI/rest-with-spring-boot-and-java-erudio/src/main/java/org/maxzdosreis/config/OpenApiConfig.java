package org.maxzdosreis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
					.title("RESTful API with Java 18 and Spring Boot 3")
					.version("v1")
					.description("Some description about your API")
					.termsOfService("")
					.license(
						new License()
							.name("Apache 2.0")
							.url("http://www.apache.org/licenses/LICENSE-2.0")));
	}
}
