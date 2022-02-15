package com.capg.vishnu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping(value="/loginhome")
	public String display() {
		return "My Controller";
		
	}
	
}