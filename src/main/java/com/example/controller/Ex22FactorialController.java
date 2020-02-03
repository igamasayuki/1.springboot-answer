package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.Ex22FactorialService;

@Controller
@RequestMapping("/ex22factorial")
public class Ex22FactorialController {
	
	@Autowired
	private Ex22FactorialService service;
	
	@RequestMapping("/view-result")
	public String viewResult(Model model) {
		model.addAttribute("result", service.getFactorial(5));
		return "result";
	}

}
