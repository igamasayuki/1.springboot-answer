package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Ex06ReceiveForm;

@Controller
@RequestMapping("/ex06")
public class Ex06Controller {

	@ModelAttribute
	public Ex06ReceiveForm setUpForm() {
		return new Ex06ReceiveForm();
	}

	@RequestMapping("")
	public String index() {
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
	@RequestMapping("/receive-info")
	public String receiveInfo(Ex06ReceiveForm receiveForm) {
		System.out.println("名前：" + receiveForm.getName());
		System.out.println("年齢：" + receiveForm.getAge());
		System.out.println("コメント：" + receiveForm.getComment());
		return "finished";
	}
}
