package com.example.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.di.logic.FactorialLogic;

@Controller
@RequestMapping("/factorial")
public class FactorialController {
	
	@Autowired
	private FactorialLogic logic;
	
	@RequestMapping("/view-result")
	public String viewResult(Model model) {
		model.addAttribute("result", logic.getFactorial(5));
		return "result";
	}

}
