package com.example.domain;

/**
 * 従業員を表すドメイン.
 * 
 * @author igamasayuki
 *
 */
public class Employee {
	/** ID */
	private Integer id;
	/** 従業員名 */
    private String name;
    /** 年齢 */
    private Integer age;
    /** 性別 */
    private String gender;
    /** 部署ID */
    private Integer departmentId;
    
    /** 部署名 (JOINする時に使用される:最後の演習で使用) */
    private String departmentName;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", departmentId="
				+ departmentId + ", departmentName=" + departmentName + "]";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
    
}
