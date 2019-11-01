package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Department;
import com.example.service.Ex24DepartmentService;

@Controller
@RequestMapping("/department")
public class Ex24DepartmentController {
	@Autowired
	private Ex24DepartmentService service;

	@RequestMapping("/execute")
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
		service.load(department.getId());
		System.out.println("削除");
		service.deleteById(department.getId());
		System.out.println();

		System.out.println("「企」検索");
		service.findByName("企").forEach(System.out::println);
		System.out.println();

		return "finished";
	}
}
