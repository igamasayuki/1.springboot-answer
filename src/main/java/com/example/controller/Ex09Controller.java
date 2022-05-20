package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Ex09ReceiveForm;

@Controller
@RequestMapping("/ex09")
public class Ex09Controller {

	// 別のやり方で行っているためコメントにしています
//	@ModelAttribute
//	public Ex09ReceiveForm setUpForm() {
//		return new Ex09ReceiveForm();
//	}

	@GetMapping("")
	public String index(Ex09ReceiveForm ex09ReceiveForm) {
		return "ex-09";
	}

	@PostMapping("/receive-info")
	public String receiveInfo(Ex09ReceiveForm receiveForm, Model model) {
		if ("abc@gmail.com".equals(receiveForm.getEmail()) && "abc".equals(receiveForm.getPass())) {
			model.addAttribute("result", "成功");
		} else {
			model.addAttribute("result", "失敗");
		}
		return "ex-09-result";
	}

}
