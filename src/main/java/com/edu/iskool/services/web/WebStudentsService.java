package com.edu.iskool.services.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edu.iskool.model.Student;

@Service
public class WebStudentsService {
	
	 @Autowired
    protected RestTemplate restTemplate;
	 
	 protected String serviceUrl;

	    public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

		protected Logger logger = Logger.getLogger(WebStudentsService.class.getName());

	    
	    
	    public Student findByStudentId(String studentId) {

	        logger.info("findByStudentId() invoked: for " + studentId);
	        try {
	            return restTemplate.getForObject(serviceUrl + "/students/{studentId}", Student.class, studentId);
	        } catch (Exception e) {
	            logger.severe(e.getClass() + ": " + e.getLocalizedMessage());
	            return null;
	        }

	    }

}
