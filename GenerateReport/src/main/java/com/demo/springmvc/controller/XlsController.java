package com.demo.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class XlsController extends AbstractController {

	@Override
	@RequestMapping(value="/viewXls",method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// user data
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("100", "Xiao.Lu");
		userData.put("102", "User 102");
		userData.put("301", "User 301");
		userData.put("400", "User 400");
		return new ModelAndView("UserSummary1", "userData", userData);
	}
}
