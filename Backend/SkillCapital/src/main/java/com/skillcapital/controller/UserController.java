package com.skillcapital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // since it is data
@RequestMapping("users") // mapping to particular url
public class UserController {
	
	@GetMapping 
	public String loginpage() {
		return "loginpage";
	}

}
