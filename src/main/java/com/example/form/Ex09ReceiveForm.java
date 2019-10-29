package com.example.form;

public class Ex09ReceiveForm {
	/** 名前 */
	private String email;
	/** パスワード */
	private String pass;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Ex09ReceiveForm [email=" + email + ", pass=" + pass + "]";
	}

}
