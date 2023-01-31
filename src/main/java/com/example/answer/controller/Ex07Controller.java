package com.example.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.answer.form.Ex07ReceiveForm;

@Controller
@RequestMapping("/ex07")
public class Ex07Controller {

	// 別のやり方で行っているためコメントにしています
//	@ModelAttribute
//	public Ex07ReceiveForm setUpForm() {
//		return new Ex07ReceiveForm();
//	}

	@GetMapping("")
	public String index(Ex07ReceiveForm ex07ReceiveForm) {
		return "ex-07";
	}

//	// 演習7
//	@PostMapping("/calc")
//	public String calc(Integer num1, Integer num2) {
//		System.out.println(num1 * num2);
//		return "finished";
//	}
	
	// 演習8
	@PostMapping("/calc")
	public String calc(Ex07ReceiveForm recieveForm) {
		System.out.println(recieveForm.getNum1() * recieveForm.getNum2());
		return "finished";
	}
}
