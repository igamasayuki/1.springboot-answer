package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.Ex26EmployeeRepository;

@Controller
@RequestMapping("/ex26")
public class Ex26Controller {
	
	@Autowired
	private Ex26EmployeeRepository repository;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("employeeList", repository.findAllWithDepartment());
		return "ex-26";
	}

}
