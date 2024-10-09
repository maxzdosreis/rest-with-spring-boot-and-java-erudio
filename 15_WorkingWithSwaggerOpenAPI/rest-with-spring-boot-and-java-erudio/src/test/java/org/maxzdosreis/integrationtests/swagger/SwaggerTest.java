package org.maxzdosreis.integrationtests.swagger;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import org.maxzdosreis.configs.TestConfigs;
import org.maxzdosreis.integrationtests.testcontainers.AbtTest;

@SpringBootApplication
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerTest extends AbtTest{
	
	@Test
	public void shouldDisplaySwaggerUiPage() {
		var content =
				given()
					.basePath("/swagger-ui/index.html")
					.port(TestConfigs.SERVER_PORT)
					.when()
						.get()
					.then()
						.statusCode(200)
					.extract()
						.body()
							.asString();
		assertTrue(content.contains("Swagger UI"));
	}

}
