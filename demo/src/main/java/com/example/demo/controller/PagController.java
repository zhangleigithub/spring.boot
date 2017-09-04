package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagController {

	@RequestMapping("personAddPage")
	public String personAddPage(){
	    return "personAdd.html";
	}
	
	@RequestMapping("personQueryPage")
	public String personQueryPage(){
	    return "personQuery.html";
	}
}
