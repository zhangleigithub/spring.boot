package com.example.mybatisDemo.model;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String state;
	private String country;

	private List<School> schools;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {

		String result = "";

		for (School item : getSchools()) {// 其内部实质上还是调用了迭代器遍历方式，这种循环方式还有其他限制，不建议使用。
			result += item;
		}

		return getId() + "," + getName() + "," + getState() + "," + getCountry() + result;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

}
