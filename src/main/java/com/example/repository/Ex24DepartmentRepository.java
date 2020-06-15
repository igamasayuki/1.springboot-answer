package com.example.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.domain.Department;

/**
 * departmentsテーブルを操作するリポジトリ.
 * 
 * @author igamasayuki
 * 
 */
@Repository
public class Ex24DepartmentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String TABLE_NAME = "departments";

	/**
	 * Departmentオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Department> Department_ROW_MAPPER = (rs, i) -> {
		Department department = new Department();
		department.setId(rs.getInt("id"));
		department.setName(rs.getString("name"));
		return department;
	};

	private SimpleJdbcInsert insert;

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName(TABLE_NAME);
		insert = withTableName.usingGeneratedKeyColumns("id");
	}

	/**
	 * 主キー検索を行う.
	 * 
	 * @param id ID
	 * @return 検索された部署情報
	 */
	public Department load(Integer id) {
		String sql = "SELECT id, name " + "FROM " + TABLE_NAME + " WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		return template.queryForObject(sql, param, Department_ROW_MAPPER);
	}

	/**
	 * 全件検索を行う.
	 * 
	 * @return 全部署一覧
	 */
	public List<Department> findAll() {
		String sql = "SELECT id, name " + "FROM " + TABLE_NAME + " ORDER BY id;";
		return template.query(sql, Department_ROW_MAPPER);
	}

	/**
	 * 渡した部署情報を保存または更新する.
	 * 
	 * @param department 部署情報
	 * @return 追加or更新された部署情報
	 */
	public Department save(Department department) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(department);
		if (department.getId() == null) {
			Number key = insert.executeAndReturnKey(param);
			department.setId(key.intValue());
			System.out.println(key + "が割り当てられました");
		} else {
			String updateSql = "UPDATE " + TABLE_NAME + " " + "SET name = :name " + "WHERE id = :id;";
			template.update(updateSql, param);
		}
		return department;
	}

	/**
	 * 主キーを使って1件の従業員情報を削除する.
	 * 
	 * @param id ID
	 */
	public void deleteById(Integer id) {
		String deleteSql = "DELETE FROM " + TABLE_NAME + " WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(deleteSql, param);
	}

	/**
	 * 部署名検索.
	 * 
	 * @param name:検索する名前
	 * @return 検索された部署名
	 */
	public List<Department> findByName(String name) {
		String sql = "SELECT id,name " + "FROM " + TABLE_NAME + " WHERE name LIKE :name " + "ORDER BY id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");
		return template.query(sql, param, Department_ROW_MAPPER);
	}

}
