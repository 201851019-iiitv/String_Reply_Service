package com.beta.replyservice;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Bean
	public ServiceLocatorFactoryBean getServiceBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(RuleEngine.class);
		return factoryBean;
	}
}
