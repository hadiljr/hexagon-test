package com.hadil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class StartApplication {
	public static void main(String[] args) {
				
		Environment env = SpringApplication.run(StartApplication.class, args).getEnvironment();
        
        log.info("Enviroment: {} \n"+
        		 "SwaggerUI:  http://localhost:{}/swagger-ui/index.html"
               , env.getActiveProfiles(),env.getProperty("server.port"));
	}
}
