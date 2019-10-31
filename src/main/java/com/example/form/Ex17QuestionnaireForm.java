package com.example.form;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * アンケート関連フォーム.
 * 
 * @author igamasayuki
 *
 */
public class Ex17QuestionnaireForm {
	/** 名前 */
	@NotBlank(message = "値を入力してください")
	@Size(min = 1, max = 127, message = "1桁以上127桁以下で入力してください")
	private String name;
	/** メールアドレス */
	@Size(min = 1, max = 127, message = "1桁以上127桁以下で入力してください")
	@Email(message = "Emailアドレス形式ではありません")
	private String mailAddress;
	/** 性別 */
	@NotNull(message = "値を入力してください")
	@Digits(integer = 1, fraction = 0, message = "不正な値です")
	public Integer gender;
	/** 趣味のリスト */
	@NotEmpty(message = "値を入力してください")
	public List<Integer> hobbyList;
	/** 好きな言語 */
	@NotNull(message = "値を入力してください")
	@Digits(integer = 1, fraction = 0, message = "不正な値です")
	public Integer language;
	/** その他 */
	@Size(min = 1, max = 2000, message = "1桁以上2000桁以下で入力してください")
	public String other;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public List<Integer> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<Integer> hobbyList) {
		this.hobbyList = hobbyList;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
