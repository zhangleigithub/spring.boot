package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PdfViewController {

	@RequestMapping(value = "/exportPdf", method = RequestMethod.GET)  
	public String exportPdf(Model model) {  
	   model.addAttribute("serverTime", new Date());  
	   return "SamplePdfView";  
	}  
}
