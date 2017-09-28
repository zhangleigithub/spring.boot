package com.example.mybatisDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.mybatisDemo.Service.CityService;
import com.example.mybatisDemo.mapper.CityMapper;
import com.example.mybatisDemo.model.School;

@EnableTransactionManagement
@SpringBootApplication
public class MybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}
	
	private final CityMapper cityMapper;
	
	private final CityService cityService;

    public MybatisDemoApplication(CityMapper cityMapper,CityService cityService) {
        this.cityMapper = cityMapper;
        this.cityService = cityService;
    }

    @Bean
    CommandLineRunner sampleCommandLineRunner() {
        return (args) -> System.out.println(this.cityMapper.findByState("CA"));
    }
    
    @Bean
    CommandLineRunner sampleCommandLineRunner2(PlatformTransactionManager platformTransactionManager) {
        return  (args) ->  System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
    }
    
    @Bean
    CommandLineRunner sampleCommandLineRunner1() {
    	
    	try {
			School s=new School();
			s.setName("T3");
			s.setCityID(1);
			this.cityService.InsertSchools(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return (args) -> System.out.println(this.cityMapper.findByState("CA"));
    }
}
