package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Person;

public interface PersonDao extends JpaRepository<Person, Long> {

}
