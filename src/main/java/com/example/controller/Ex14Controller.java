package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex14")
public class Ex14Controller {

	@GetMapping("")
	public String index(Model model) {

		List<String> nameList = new ArrayList<>();
		String[] names = { "伊賀", "鈴木", "伊藤", "吉田", "佐藤" };
		for (String name : names) {
			nameList.add(name);
		}
		model.addAttribute("nameList", nameList);
		return "ex-14";
	}

}
