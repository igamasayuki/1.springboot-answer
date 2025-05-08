package com.example.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.answer.domain.Department;
import com.example.answer.service.Ex24DepartmentService;

@Controller
@RequestMapping("/department")
public class Ex24DepartmentController {
	@Autowired
	private Ex24DepartmentService service;

	@GetMapping("/execute")
	public String execute() {
		System.out.println("全件検索");
		service.findAll().forEach(System.out::println);
		System.out.println();

		System.out.println("追加");
		Department department = new Department();
		department.setName("開発総本部");
		department = service.save(department);
		System.out.println();

		System.out.println("主キー検索");
		service.findById(department.getId());
		System.out.println("削除");
		service.deleteById(department.getId());
		System.out.println();

		System.out.println("「企」検索");
		service.findByName("企").forEach(System.out::println);
		System.out.println();

		return "finished";
	}
}
