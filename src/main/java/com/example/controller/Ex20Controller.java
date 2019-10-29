package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex20")
public class Ex20Controller {
	
	@RequestMapping("")
	public String index() {
		return "ex-20-index";
	}

}
