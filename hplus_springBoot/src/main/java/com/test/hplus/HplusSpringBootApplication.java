package com.test.hplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HplusSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HplusSpringBootApplication.class, args);
		//we can run this spring-boot application with main method.but tomact does not provide full support for.
		//Thst why we have added jsp dependencies in pom.xml
	}

}
