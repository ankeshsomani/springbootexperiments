package com.ankesh.springrestsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringRestSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestSoapApplication.class, args);
		
	}

}
