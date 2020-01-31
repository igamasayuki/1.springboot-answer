package com.example.form;

import javax.validation.constraints.Pattern;

public class Ex19Form {

	@Pattern(regexp ="^[0-9]+$", message="半角数字を入力してください")
	private String num1;

	@Pattern(regexp ="^[0-9]+$", message="半角数字を入力してください")
	private String num2;

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}


}
