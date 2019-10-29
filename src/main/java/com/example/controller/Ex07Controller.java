package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Ex07ReceiveForm;

@Controller
@RequestMapping("/ex07")
public class Ex07Controller {

	@ModelAttribute
	public Ex07ReceiveForm setUpForm() {
		return new Ex07ReceiveForm();
	}

	@RequestMapping("")
	public String index() {
		return "ex-07";
	}

	// 演習7
//	@RequestMapping("/calc")
//	public String calc(String num1, String num2) {
//		System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2));
//		return "finished";
//	}
	
	// 演習8
	@RequestMapping("/calc")
	public String calc(Ex07ReceiveForm recieveForm) {
		System.out.println(recieveForm.getIntNum1() * recieveForm.getIntNum2());
		return "finished";
	}
}
