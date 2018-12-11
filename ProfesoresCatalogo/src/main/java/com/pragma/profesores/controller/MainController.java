package com.pragma.profesores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = " Bienvenido a pragma <a href='http://www.pragma.com.co/es/'>www.pragma.com.co/es/</a> ";
		return response;
	}
	
	

}
