package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.repository.Ex26EmployeeRepository;

@Controller
@RequestMapping("/ex26")
public class Ex26Controller {
	
	@Autowired
	private Ex26EmployeeRepository repository;
	
	@GetMapping("")
	public String index(Model model) {
		final List<Employee> employeeList = repository.findAllWithDepartment();
		model.addAttribute("employeeList", employeeList);
		return "ex-26";
	}

}
