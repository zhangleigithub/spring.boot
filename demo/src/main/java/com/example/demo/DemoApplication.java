package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ComponentScan(basePackages={"com.example.demo"}) 
@EnableJpaRepositories("com.example.demo.Dao") 
@EntityScan("com.example.demo.Entities") 
@Controller
@SpringBootApplication
public class DemoApplication {

	 @Value("${name}")
	 private String name;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Wecome Spring boot."+name;
    }
	
	@RequestMapping("indexPage")
	public String indexPage(){
	    return "index.html";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Start");
	}
}
