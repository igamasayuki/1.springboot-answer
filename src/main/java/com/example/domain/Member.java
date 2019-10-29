package com.example.domain;

public class Member {
	/** 名前 */
	private String name;
	/** 年齢 */
	private Integer age;
	/** コメント */
	private String comment;
	/** 所持金 */
	private Integer money;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

}
