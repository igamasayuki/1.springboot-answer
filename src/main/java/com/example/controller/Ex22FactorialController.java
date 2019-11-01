package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.logic.Ex22FactorialLogic;

@Controller
@RequestMapping("/ex22factorial")
public class Ex22FactorialController {
	
	@Autowired
	private Ex22FactorialLogic logic;
	
	@RequestMapping("/view-result")
	public String viewResult(Model model) {
		model.addAttribute("result", logic.getFactorial(5));
		return "result";
	}

}
