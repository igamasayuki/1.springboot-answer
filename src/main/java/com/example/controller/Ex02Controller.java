package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	
	@RequestMapping("/show-kana-name")
	public String showKanaName() {
		return "redirect:/ex02/kana";
	}
	
	@RequestMapping("/kana")
	public String showKanaName2() {
		return "ex-02";
	}
	
}
