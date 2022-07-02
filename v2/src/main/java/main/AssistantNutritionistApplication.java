package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"rest", "db", "main"})
@EnableJpaRepositories(basePackages = "db.repo")
@EntityScan(basePackages = "db")
public class AssistantNutritionistApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistantNutritionistApplication.class, args);
	}

}
