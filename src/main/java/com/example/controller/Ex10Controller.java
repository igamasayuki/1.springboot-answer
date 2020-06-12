package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.Ex10ReceiveForm;

@Controller
@RequestMapping("/ex10")
public class Ex10Controller {

	@Autowired
	private HttpSession session;

	@ModelAttribute
	public Ex10ReceiveForm setUpForm() {
		return new Ex10ReceiveForm();
	}

	@RequestMapping("")
	public String index() {
		return "ex-10-input";
	}

	@RequestMapping("/input")
	public String inputs(Ex10ReceiveForm receiveForm) {
		
		User user = new User();
		user.setName(receiveForm.getName());
		user.setAge(receiveForm.getIntAge());
		user.setComment(receiveForm.getComment());
		user.setBirthDay(receiveForm.getLocalDate());
		
		session.setAttribute("user", user);
		
		return "ex-10-output";
	}

	@RequestMapping("/output2")
	public String output2() {
		return "ex-10-output2";
	}

	@RequestMapping("/output")
	public String output() {
		return "ex-10-output";
	}

}
