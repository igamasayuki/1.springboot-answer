package com.example.answer.repository;

import com.example.answer.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * employeesテーブル(とdepartmentsテーブル)を操作するリポジトリ.
 *
 * @author igamasayuki
 */
@Repository
public class Ex26EmployeeRepository {

    /**
     * Employeeオブジェクトを生成するローマッパー(結合版).
     */
    private static final RowMapper<Employee> EMPLOYEE_JOIN_DEPARTMENT_ROW_MAPPER = (rs, i) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("e_id"));
        employee.setName(rs.getString("e_name"));
        employee.setAge(rs.getInt("e_age"));
        employee.setGender(rs.getString("e_gender"));
        employee.setDepartmentId(rs.getInt("e_department_id"));
        employee.setDepartmentName(rs.getString("d_name"));
        return employee;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 従業員一覧情報を年齢順で取得します. この時、部署テーブルも結合させて部署名も一緒に取得します。
     *
     * @return 部署名を含めた全従業員一覧 従業員が存在しない場合はサイズ0件の従業員一覧を返します
     */
    public List<Employee> findAllWithDepartment() {
        String sql = """
                SELECT e.id AS e_id,
                       e.name AS e_name,
                       e.age AS e_age,
                       e.gender AS e_gender,
                       e.department_id AS e_department_id,
                       d.name AS d_name
                  FROM employees e
                  INNER JOIN departments d
                    ON e.department_id = d.id
                 ORDER BY e.age DESC
                """;

        return template.query(sql, EMPLOYEE_JOIN_DEPARTMENT_ROW_MAPPER);
    }

}
