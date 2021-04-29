package io.playdata.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"config.**", "person.**", "course.**", "personcourse.**", "attachedfile.**", "career.**"})
@EnableJpaRepositories(basePackages = {"person.**", "course.**", "personcourse.**", "attachedfile.**", "career.**"})
@EntityScan(basePackages = {"person.**", "course.**", "personcourse.**", "attachedfile.**", "career.**"})
public class ApplicationSwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationSwApplication.class, args);
	}

}
