package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.Ex11ReceiveForm;

@Controller
@RequestMapping("/ex11")
public class Ex11Controller {

	@Autowired
	private ServletContext application;

	@ModelAttribute
	public Ex11ReceiveForm setUpForm() {
		return new Ex11ReceiveForm();
	}

	@RequestMapping("")
	public String index() {
		return "ex-11-input";
	}

	@RequestMapping("/input")
	public String inputs(Ex11ReceiveForm receiveForm) {
		User user = new User();
		user.setName(receiveForm.getName());
		user.setAge(receiveForm.getIntAge());
		user.setComment(receiveForm.getComment());
		user.setBirthDay(receiveForm.getLocalDate());
		application.setAttribute("user", user);
		return "ex-11-output";
	}

	@RequestMapping("/output2")
	public String output2() {
		return "ex-11-output2";
	}

	@RequestMapping("/output")
	public String output() {
		return "ex-11-output";
	}

}
