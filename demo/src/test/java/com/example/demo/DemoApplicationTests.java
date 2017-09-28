package com.example.demo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Resource
	private PersonService personService;

	@Test
	public void contextLoads() {

		personService.add(new Person(1, "Test"));
		List<Person> ps = personService.query(1);

		System.out.println("contextLoads");
		System.out.println(ps.get(0).getName());
	}

}
