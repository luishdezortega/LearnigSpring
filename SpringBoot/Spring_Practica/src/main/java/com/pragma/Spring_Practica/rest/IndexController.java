package com.pragma.Spring_Practica.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage(){
		return "UserManagement";
	}
}
