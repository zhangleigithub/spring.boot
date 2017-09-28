package com.example.mybatisDemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

import org.apache.ibatis.annotations.Many;

import com.example.mybatisDemo.model.City;
import com.example.mybatisDemo.model.School;

@Mapper
public interface CityMapper {

    @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
    @Results({  
    	@Result(id=true, column="id", property="id"),  
    	@Result(column="name", property="name"),  
    	@Result(column="state", property="state"),  
    	@Result(column="country", property="country"),  
    	@Result(property="schools", column="id",  
    	many=@Many(select="com.example.mybatisDemo.mapper.CityMapper.findSchoolByCityID"))  
    	})  
    City findByState(String state);
    
    @Select("SELECT id, name, cityID FROM school WHERE cityID = #{cityID}")
    List<School> findSchoolByCityID(String cityID);
    
    @Select("INSERT INTO School(name,cityID)VALUES(#{name}, #{cityID})")
    void InsertSchools(School s);
}