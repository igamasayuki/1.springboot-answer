package com.example.domain;

/**
 * 部署情報を表すドメイン.
 * 
 * @author igamasayuki
 *
 */
public class Department {
	/** ID */
	private Integer id;
	/** 部署名 */
    private String name;
    
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
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
}
