package com.rams.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/Rams")
@RestController
public class RamsSpringBoot1Controller {

	@RequestMapping("/")
	public String helloRams1() {
		return "Rams1--- Welcome to SpringBoot------------";
	}
	
	@RequestMapping("/rams2") 
	public String helloRams2() { 
		 return "Rams2--- Welcome to SpringBoot---------"; 
	}
	 
}
