package com.example.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.answer.form.Ex19Form;

@Controller
@RequestMapping("/ex19")
public class Ex19Controller {

	// 別のやり方で実装しているためコメント
//	@ModelAttribute
//	public Ex19Form setUpForm() {
//		return new Ex19Form();
//	}

	@GetMapping("")
	public String index(Ex19Form form) {
		return "ex-19";
	}

	@PostMapping("/receive-num")
	public String calc(@Validated Ex19Form form, BindingResult result, RedirectAttributes redirectAttribute) {

		if (result.hasErrors()) {
			return index(form);
		} else {

			Integer num1 = Integer.parseInt(form.getNum1());
			Integer num2 = Integer.parseInt(form.getNum2());
			Integer answer = num1 + num2;
			redirectAttribute.addFlashAttribute("answer", answer);
			return "redirect:/ex19/toresult";
		}
	}

	@GetMapping("/toresult")
	public String toResult() {
		return "ex-19-result";
	}
}
