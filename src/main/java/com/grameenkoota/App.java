package com.grameenkoota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages = { "com.grameenkoota.dao,com.grameenkoota.domain,com.grameenkoota.rest,com.grameenkoota.service" })
public class App extends SpringBootServletInitializer{



	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		 
	      return builder.sources(App.class);
	  }

}
