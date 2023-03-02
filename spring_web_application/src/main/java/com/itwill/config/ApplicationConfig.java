package com.itwill.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractResourceBasedMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration //->있어야 설정파일
public class ApplicationConfig {
	
	/*****************MessageSource객체등록************************/
	@Bean("messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames("messages/messages","messages/user"); //classpath기술
	return resourceBundleMessageSource;
	}
	
}
