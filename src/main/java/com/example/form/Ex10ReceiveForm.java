package com.example.form;

import java.sql.Date;
import java.time.LocalDate;

public class Ex10ReceiveForm {
	/** 名前 */
	private String name;
	/** 年齢 */
	private String age;
	/** 誕生日 */
	private Date birthDay;
	/** コメント */
	private String comment;
	
	public Integer getIntAge() {
		return Integer.parseInt(age);
	}
	public LocalDate getLocalDate() {
		return birthDay.toLocalDate();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
