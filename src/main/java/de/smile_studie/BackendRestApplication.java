package de.smile_studie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendRestApplication.class, args);
	}

	//TODO disable exceptions in HTTP answers
}
