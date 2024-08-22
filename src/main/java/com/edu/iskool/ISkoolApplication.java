package com.edu.iskool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({"com.edu.iskool","com.edu.iskool.services"})
@EnableEurekaServer
public class ISkoolApplication {
    public static final String REGISTRATION_SERVER_HOSTNAME = "registration.server.hostname";

	public static void main(String[] args) {
		 // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "registration-server");

		SpringApplication.run(ISkoolApplication.class, args);
	}

}
