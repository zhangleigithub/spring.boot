package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class XlsViewController {

	@RequestMapping(value = "/exportXls", method = RequestMethod.GET)
	public String exportXls(Model model) {
		// user data
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("100", "Xiao.Lu");
		userData.put("102", "User 102");
		userData.put("301", "User 301");
		userData.put("400", "User 400");
		model.addAttribute("userData", userData);
		return "SampleXlsView";
	}
}
