package com.example.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.answer.domain.Employee;
import com.example.answer.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee findById(Integer id) {
		return repository.findById(id);
	}

	public List<Employee> findAll() {
		return repository.findAll();
	}

	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
