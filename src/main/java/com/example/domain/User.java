package com.example.domain;

import java.time.LocalDate;

public class User {
	
	/** 名前 */
	private String name;
	/** 年齢 */
	private Integer age;
	/** 誕生日 */
	private LocalDate birthDay;
	/** コメント */
	private String comment;
	
	
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
	
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
