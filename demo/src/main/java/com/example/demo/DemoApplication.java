package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@ComponentScan(basePackages = { "com.example.demo" })
@EnableJpaRepositories("com.example.demo.Dao")
@EntityScan("com.example.demo.Entities")
@Controller
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5)
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	@Value("${name}")
	private String name;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Wecome Spring boot." + name;
	}

	@RequestMapping("indexPage")
	public String indexPage() {
		return "index.html";
	}

	@RequestMapping(value = "/first", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> firstResp(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute("request Url", request.getRequestURL());
		map.put("request Url", request.getRequestURL());
		return map;
	}

	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	@ResponseBody
	public Object sessions(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		map.put("message", request.getSession().getAttribute("request Url"));
		return map;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Start");
	}
}
