package com.example.sample.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * ユーザ情報のリクエストパラメータを受け取るフォームクラス.
 *
 * @author igamasayuki
 */
public class UserForm {
    /**
     * 名前
     */
    @NotBlank(message = "名前は必須です")
    private String name;
    /**
     * メールアドレス
     */
    @Size(min = 1, max = 127, message = "Eメールは1文字以上127文字以内で記載してください")
    @Email(message = "Eメールの形式が不正です")
    private String email;
    /**
     * パスワード
     */
    @Size(min = 1, max = 127, message = "パスワードは1文字以上127文字以内で記載してください")
    private String password;
    /**
     * 趣味のリスト
     */
    @NotEmpty(message = "趣味は１つ以上選択してください")
    private List<Integer> hobbyList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Integer> hobbyList) {
        this.hobbyList = hobbyList;
    }

    @Override
    public String toString() {
        return "UserForm [name=" + name + ", email=" + email + ", password=" + password + ", hobbyList=" + hobbyList
                + "]";
    }

}
