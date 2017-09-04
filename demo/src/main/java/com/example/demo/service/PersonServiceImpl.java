package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.entities.Person;

/**
 * 
 * @author zhanglei
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	/**
	 * 添加数据
	 */
	@Override
	public void add(Person person) {
		
		if (person==null) {
			
			throw new NullPointerException("person");
		}
		personDao.save(person);
	}

	/**
	 * 查询数据
	 */
	@Override
	public List<Person> query(int personId) {
		
		List<Long> li = new ArrayList<>();
		li.add((long) personId);
		
		return personDao.findAllById(li);
	}

}
