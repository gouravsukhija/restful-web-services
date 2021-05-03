package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.apache.catalina.core.ApplicationContext;
import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
		
		//ApplicationContext.
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		
		SessionLocaleResolver localeRes=new SessionLocaleResolver();
		localeRes.setDefaultLocale(Locale.US);
		
		return localeRes;
		
	}
	
	@Bean
	public AbstractMessageSource MessageSource() {
		
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		
		messageSource.setBasename("messages");
		
		return messageSource;
		
	}

}
