package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	private final static String SUCCESS_EMAIL="abc@gmail.com";
	private final static String SUCCESS_PASSWORD="abc";
	
	@RequestMapping("")
	public String index() {
		return "ex-04";
	}
	
	@RequestMapping("/login")
	public String login(String email,String pass) {
		if(SUCCESS_EMAIL.equals(email) & SUCCESS_PASSWORD.equals(pass) ) {
			return "ex-04-success";
		}else {
			return "ex-04-failure";
		}
	}

}
