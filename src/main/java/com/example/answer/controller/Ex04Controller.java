package com.example.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	
	@GetMapping("")
	public String index() {
		return "ex-04";
	}
	
	@PostMapping("/login")
	public String login(String email,String pass) {
		if("abc@gmail.com".equals(email) & "abc".equals(pass) ) {
			return "ex-04-success";
		}else {
			return "ex-04-failure";
		}
	}

}
