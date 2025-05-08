package com.example.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.answer.domain.Department;
import com.example.answer.repository.Ex24DepartmentRepository;

@Service
@Transactional
public class Ex24DepartmentService {

	@Autowired
	private Ex24DepartmentRepository repository;

	public Department findById(Integer id) {
		return repository.findById(id);
	}

	public List<Department> findAll() {
		return repository.findAll();
	}

	public Department save(Department Department) {
		return repository.save(Department);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public List<Department> findByName(String name) {
		return repository.findByName(name);
	}
}
