package org.maxzdosreis.integrationtests.testcontainers;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;


import java.util.Map;

@ContextConfiguration(initializers = AbtTest.Initializer.class)
public class AbtTest {

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{
		
		public static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.4.2");
		
		private static void startContainers() {
			Startables.deepStart(Stream.of(mysql)).join();
		}
		
		private static Map<String, Object> createConnectionConfiguration() {
			return Map.of(
				"spring.datasource.url", mysql.getJdbcUrl(),
				"spring.datasource.username", mysql.getUsername(),
				"spring.datasource.password", mysql.getPassword()
					);
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			startContainers();
			ConfigurableEnvironment environment = applicationContext.getEnvironment();
			MapPropertySource testcontainers = new MapPropertySource(
				"testcontainers",
				(Map) createConnectionConfiguration());
			environment.getPropertySources().addFirst(testcontainers);
		}
	}
}
