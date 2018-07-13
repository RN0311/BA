package com.rashmi.behaviouranalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class BehaviourAnalyticsApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BehaviourAnalyticsApplication.class);
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(BehaviourAnalyticsApplication.class, args);
	}
}
