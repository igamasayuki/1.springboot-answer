package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeContoroller {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/execute")
	public String execute() {
		
		System.out.println("全件検索");
		service.findAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println("追加");
		Employee employee = new Employee();
		employee.setName("山田太郎");
		employee.setAge(20);
		employee.setGender("男");
		employee.setDepartmentId(1);
		employee = service.save(employee);
		System.out.println(employee+ "が追加されました");
		System.out.println();
		
		System.out.println("主キー検索");
		Employee employee2 = service.load(employee.getId());
		System.out.println(employee2);
		
		System.out.println("削除");
		service.deleteById(employee.getId());
		
		return "finished";
	}

}
