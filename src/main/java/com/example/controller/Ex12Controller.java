package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.form.Ex12ReceiveForm;

@Controller
@RequestMapping("/ex12")
public class Ex12Controller {
	
	@ModelAttribute
	public Ex12ReceiveForm setUpForm() {
		return new Ex12ReceiveForm();
	}

	@RequestMapping("")
	public String index() {
		return "ex-12-register-member";
	}

	@RequestMapping("/input")
	public String input(Ex12ReceiveForm receiveForm, Model model) {
		
		Member member = new Member();
		member.setName(receiveForm.getName());
		member.setAge(receiveForm.getIntAge());
		member.setComment(receiveForm.getComment());
		member.setMoney(receiveForm.getIntMoney());
		
		model.addAttribute("member", member);
		
		return "ex-12-register-member-output";
	}

}
