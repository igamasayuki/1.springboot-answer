package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@RequestMapping("/execute")
	public String execute() {
		String sql="SELECT count(*) FROM employees"
				+ "WHERE id = :firstId OR id = secondId";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("firstId", 1).addValue("secondId", 3);
		Integer result = template.queryForObject(sql, param, Integer.class);
		System.out.println("result = " + result);
		
		return "finished";
	}
	
	@RequestMapping("/execute2")
	public String execute2() {
		String sql="SELECT count(*) FROM developments "
				+ "WHERE development_name = :firstName OR development_name = :secondName";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("firstName", "総務部").addValue("secondName", "技術部");
		Integer result = template.queryForObject(sql, param, Integer.class);
		System.out.println("件数" + result);
		
		return "finished";
	}
	
	@RequestMapping("/execute3")
	public String execute3() {
		String sql="SELECT name FROM employees";
		SqlParameterSource param = new MapSqlParameterSource();
//		List<Map<String,Object>> result = template.queryForList(sql, param);
//		for(Map<String,Object> map:result) {
//			for(Entry<String, Object> name:map.entrySet()) {
//				System.out.println(name);
//			}
//		}
		
		List<String> result = template.queryForList(sql, param,String.class);
		for(String name:result) {
			System.out.println(name);
		}
		
		return "finished";
	}
}
