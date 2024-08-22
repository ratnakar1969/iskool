package com.edu.iskool.services.student;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.edu.iskool.dao.StudentRepository;
import com.edu.iskool.services.registration.RegistrationServer;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentServer {
	
	   @Autowired
	    protected StudentRepository studentRepository;

	    protected Logger logger = Logger.getLogger(StudentServer.class.getName());

	    /**
	     * Run the application using Spring Boot and an embedded servlet engine.
	     * 
	     * @param args Program arguments - ignored.
	     */
	    public static void main(String[] args) {
	        // Default to registration server on localhost
	        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
	            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

	        // Tell server to look for accounts-server.properties or
	        // accounts-server.yml
	        System.setProperty("spring.config.name", "students-server");

	        SpringApplication.run(StudentServer.class, args);
	    }

}
