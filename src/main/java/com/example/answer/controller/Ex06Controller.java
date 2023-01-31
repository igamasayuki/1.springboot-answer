package com.example.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.answer.form.Ex06ReceiveForm;

@Controller
@RequestMapping("/ex06")
public class Ex06Controller {

	// 別のやり方で行っているためコメントにしています
//	@ModelAttribute
//	public Ex06ReceiveForm setUpForm() {
//		return new Ex06ReceiveForm();
//	}

	@GetMapping("")
	public String index(Ex06ReceiveForm ex06ReceiveForm) {
		return "ex-06";
	}

	// 演習6
//	@RequestMapping("/receive-info")
//	public String receiveInfo(String name, String age, String comment) {
//		System.out.println("名前：" + name);
//		System.out.println("年齢：" + age);
//		System.out.println("コメント：" + comment);
//		return "finished";
//	}

	// 演習8
	@PostMapping("/receive-info")
	public String receiveInfo(Ex06ReceiveForm receiveForm) {
		System.out.println("名前：" + receiveForm.getName());
		System.out.println("年齢：" + receiveForm.getAge());
		System.out.println("コメント：" + receiveForm.getComment());
		return "finished";
	}
}
