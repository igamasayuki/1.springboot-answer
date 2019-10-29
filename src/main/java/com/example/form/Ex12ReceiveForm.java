package com.example.form;

public class Ex12ReceiveForm {
	/** 名前 */
	private String name;
	/** 年齢 */
	private String age;
	/** コメント */
	private String comment;
	/** 所持金 */
	private String money;
	
	public Integer getIntAge() {
		return Integer.parseInt(age);
	}
	public Integer getIntMoney() {
		return Integer.parseInt(money);
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

	
	
}
