package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Person;

public interface PersonService {

	public void add(Person person);
	
	public List<Person> query(int personId);
}
