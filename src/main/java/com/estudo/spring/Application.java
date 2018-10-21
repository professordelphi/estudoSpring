package com.estudo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages="com.estudo.spring.model")
@ComponentScan(basePackages={"com.estudo.spring","controller"})
@EnableJpaRepositories(basePackages={"com.estudo.spring.repository"})
@EnableTransactionManagement
public class Application {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
		
	}
}
