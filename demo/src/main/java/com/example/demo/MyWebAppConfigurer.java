package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@SuppressWarnings("deprecation")
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Bean
	public ResourceBundleViewResolver viewResolver() {
	    ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
	    resolver.setOrder(1);
	    resolver.setBasename("views");
	    return resolver;
	}
}
