package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.form.Ex12ReceiveForm;

@Controller
@RequestMapping("/ex12")
public class Ex12Controller {
	
	// 別のやり方で行っているためコメントにしています
//	@ModelAttribute
//	public Ex12ReceiveForm setUpForm() {
//		return new Ex12ReceiveForm();
//	}

	@GetMapping("")
	public String index(Ex12ReceiveForm ex12ReceiveForm) {
		ex12ReceiveForm.setName("aaa");
		return "ex-12-register-member";
	}

	@PostMapping("/input")
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
