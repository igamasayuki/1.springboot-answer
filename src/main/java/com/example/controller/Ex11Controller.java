package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.Ex11ReceiveForm;

@Controller
@RequestMapping("/ex11")
public class Ex11Controller {

	@Autowired
	private ServletContext application;

	// 別のやり方で行っているためコメントにしています
//	@ModelAttribute
//	public Ex11ReceiveForm setUpForm() {
//		return new Ex11ReceiveForm();
//	}

	@GetMapping("")
	public String index(Ex11ReceiveForm ex11ReceiveForm) {
		return "ex-11-input";
	}

	@PostMapping("/input")
	public String inputs(Ex11ReceiveForm receiveForm) {
		User user = new User();
		user.setName(receiveForm.getName());
		user.setAge(receiveForm.getIntAge());
		user.setComment(receiveForm.getComment());
		user.setBirthDay(receiveForm.getLocalDate());
		application.setAttribute("user", user);
		return "ex-11-output";
	}

	@GetMapping("/output")
	public String output() {
		return "ex-11-output";
	}

	@GetMapping("/output2")
	public String output2() {
		return "ex-11-output2";
	}

}
