package com.walmartassignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.walmartassignment.resource.ProductResource;

@SpringBootApplication
@EnableHystrix
public class WalmartAssignmentApplication {

	private static final Logger logger = LoggerFactory.getLogger(WalmartAssignmentApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WalmartAssignmentApplication.class, args);
		logger.debug("Application Started ...");
	}

}
