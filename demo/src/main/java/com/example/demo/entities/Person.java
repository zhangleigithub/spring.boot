package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_Person")
public class Person {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "tname")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Person() {
	}
	
	public Person(long id, String name) {
		this.id = id;
		this.name = name;
	}
}
