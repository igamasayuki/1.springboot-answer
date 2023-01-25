package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.Ex10ReceiveForm;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ex10")
public class Ex10Controller {

	@Autowired
	private HttpSession session;

	// 別のやり方で行っているためコメントにしています
//	@ModelAttribute
//	public Ex10ReceiveForm setUpForm() {
//		return new Ex10ReceiveForm();
//	}
	@GetMapping("")
	public String index(Ex10ReceiveForm ex10ReceiveForm) {
		return "ex-10-input";
	}

//	@PostMapping("/input")
//	public String input(String name, String age, String comment, Date date) {
//
//		User user = new User();
//		user.setName(name);
//		user.setAge(Integer.parseInt(age));
//		user.setComment(comment);
//		user.setBirthDay(date.toLocalDate());
//
//		session.setAttribute("user", user);
//
//		return "ex-10-output";
//	}
	
	@PostMapping("/input")
	public String input(Ex10ReceiveForm receiveForm) {

		User user = new User();
		user.setName(receiveForm.getName());
		user.setAge(receiveForm.getIntAge());
		user.setComment(receiveForm.getComment());
		user.setBirthDay(receiveForm.getLocalDate());

		session.setAttribute("user", user);

		return "ex-10-output";
	}

	@GetMapping("/output")
	public String output() {
		return "ex-10-output";
	}

	@GetMapping("/output2")
	public String output2() {
		return "ex-10-output2";
	}

}
