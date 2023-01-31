package com.example.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	
	@GetMapping("/show-kana-name")
	public String showKanaName() {
		return "redirect:/ex02/kana";
	}
	
	@GetMapping("/kana")
	public String showKanaName2() {
		return "ex-02";
	}
	
}
