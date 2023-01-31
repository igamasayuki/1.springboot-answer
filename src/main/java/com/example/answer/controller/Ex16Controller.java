package com.example.answer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.answer.domain.User;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/ex16")
public class Ex16Controller {
	@Autowired
	public ServletContext application;

	@GetMapping("")
	public String index() {

		@SuppressWarnings("unchecked") // 警告を消すためのアノテーション
		List<User> userList = (List<User>) application.getAttribute("userList");

		if (userList == null) {
			userList = new ArrayList<>();
		}

		application.setAttribute("userList", userList);

		return "ex-16";
	}

	@PostMapping("/post")
	public String input(String name, String comment) {

		User user = new User();
		user.setName(name);
		user.setComment(comment);

		@SuppressWarnings("unchecked") // 警告を消すためのアノテーション
		List<User> userList = (List<User>) application.getAttribute("userList");

		userList.add(0, user);

		// 上記でapplicationスコープ内にあるuserListに追加しているので
		// 再度以下の行のようにapplicationスコープを上書きする必要無し
		// application.setAttribute("userList", userList);

		// 投稿後、更新ボタンを押した際に再度投稿されてしまう現象をリダイレクトで防ぐ
		return "redirect:/ex16";
	}

}
