package ua.edu.duan.lesson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

@EnableJpaRepositories
@SpringBootApplication
@EnableRetry
public class Lesson3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson3Application.class, args);
	}

}
