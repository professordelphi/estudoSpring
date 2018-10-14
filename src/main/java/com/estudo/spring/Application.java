package com.estudo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@EnableAutoConfiguration
//@EntityScan(basePackages="com.estudo.spring.model")
//@ComponentScan(basePackages={"com.estudo.spring","controller"})
//@EnableJpaRepositories(basePackages={"com.estudo.spring.repository"})
//@EnableTransactionManagement
public class Application {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
		
	}
}
