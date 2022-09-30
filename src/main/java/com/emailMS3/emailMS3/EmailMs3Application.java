package com.emailMS3.emailMS3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.emailMS3.controllers"})
public class EmailMs3Application {

	public static void main(String[] args) {
		SpringApplication.run(EmailMs3Application.class, args);
	}

}
