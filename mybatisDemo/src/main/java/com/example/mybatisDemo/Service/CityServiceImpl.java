package com.example.mybatisDemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatisDemo.mapper.CityMapper;
import com.example.mybatisDemo.model.School;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Transactional
	@Override
	public void InsertSchools(School s) {

		// TODO Auto-generated method stub
		this.cityMapper.InsertSchools(s);

		School s1 = new School();
		s1.setName(
				"T111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
//		s1.setName("error");
		s1.setCityID(1);
		this.cityMapper.InsertSchools(s1);
	}

}
