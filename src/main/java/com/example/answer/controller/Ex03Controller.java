package com.example.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@GetMapping("/show-image")
	public String showImage() {
		return "ex-03";
	}
	
}
