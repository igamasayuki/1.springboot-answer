package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Department;
import com.example.repository.Ex24DepartmentRepository;

@Service
@Transactional
public class Ex24DepartmentService {

	@Autowired
	private Ex24DepartmentRepository repository;

	public Department load(Integer id) {
		return repository.load(id);
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
