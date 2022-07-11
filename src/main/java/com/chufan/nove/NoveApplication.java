package com.chufan.nove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.chufan.nove.utils.StringUtils;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class NoveApplication {

	public static void main(String[] args) {
		System.out.println("Main method");
		System.out.println("Spring boot start,AA Ver:" +
				StringUtils.GetVersion());
		SpringApplication.run(NoveApplication.class, args);
	}

	@Bean
	MessageConverter createMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	// -- Mvc configuration ---------------------------------------------------

	@Bean
	WebMvcConfigurer createWebMvcConfigurer(@Autowired HandlerInterceptor[] interceptors) {
		return new WebMvcConfigurer() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
			}
		};
	}
}
