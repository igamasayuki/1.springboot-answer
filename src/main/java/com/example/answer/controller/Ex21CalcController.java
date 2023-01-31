package com.example.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.answer.service.Ex21CalcService;

@Controller
@RequestMapping("/ex22calc")
public class Ex21CalcController {
	
	@Autowired
	private Ex21CalcService calcService;
	
	@GetMapping("/add")
	public String add() {
		int num1=2;
		int num2=3;
		int resultOfAdd = calcService.add(num1, num2);
		System.out.println(num1+"+"+num2+"="+resultOfAdd);
		return "finished";
	}
	@GetMapping("/sub")
	public String sub() {
		int num1=2;
		int num2=3;
		int resultOfAdd = calcService.sub(num1, num2);
		System.out.println(num1+"-"+num2+"="+resultOfAdd);
		return "finished";
	}
	
	@GetMapping("/multi")
	public String multi() {
		int num1=2;
		int num2=3;
		int resultOfAdd = calcService.multi(num1, num2);
		System.out.println(num1+"*"+num2+"="+resultOfAdd);
		return "finished";
	}
	
	@GetMapping("/div")
	public String div() {
		int num1=2;
		int num2=3;
		int resultOfAdd = calcService.div(num1, num2);
		System.out.println(num1+"/"+num2+"="+resultOfAdd);
		return "finished";
	}

}
