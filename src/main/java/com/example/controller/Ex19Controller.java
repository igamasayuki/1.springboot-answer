package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.Ex19Form;

@Controller
@RequestMapping("/ex19")
public class Ex19Controller {

	@ModelAttribute
	public Ex19Form setUpForm() {
		return new Ex19Form();
	}

	@RequestMapping("")
	public String index() {
		return "ex-19";
	}

	@RequestMapping("/receive-num")
	public String calc(@Validated Ex19Form ex19Form, BindingResult result, RedirectAttributes redirectAttribute) {

		if (result.hasErrors()) {
			return index();
		} else {

			Integer num1 = Integer.parseInt(ex19Form.getNum1());
			Integer num2 = Integer.parseInt(ex19Form.getNum2());
			Integer answer = num1 + num2;
			redirectAttribute.addFlashAttribute("answer", answer);
			return "redirect:/ex19/toresult";
		}
	}

	@RequestMapping("/toresult")
	public String toResult() {
		return "ex-19-result";
	}
}
