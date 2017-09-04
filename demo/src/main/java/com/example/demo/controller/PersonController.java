package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;
    
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@Valid Person person, BindingResult result){
        personService.add(person);
        return "ok.UserController.add";
    }
    
    @RequestMapping(value="/query", method=RequestMethod.GET)
    @ResponseBody
    public List<Person> query(@RequestParam("personId") String personId){
        return personService.query(Integer.parseInt(personId));
    }
}
