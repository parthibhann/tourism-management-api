package com.tourism.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude = {
      SecurityAutoConfiguration.class,
      ManagementWebSecurityAutoConfiguration.class
})
public class TourismManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourismManagementApiApplication.class, args);
	}

}
