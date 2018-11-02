package com.main;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication 
@EnableMongoRepositories("com.ocr.repository")
public class OCRApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OCRApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8099"));
		        app.run(args);

	}

	

}
