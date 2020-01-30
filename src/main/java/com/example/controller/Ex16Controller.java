package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;

@Controller
@RequestMapping("/ex16")
public class Ex16Controller {
	@Autowired
	public ServletContext application;

	@SuppressWarnings("unchecked")
	@RequestMapping("")
	public String index() {
		
		List<User> userList = (List<User>) application.getAttribute("userList");
		
		if (userList == null) {
			userList = new ArrayList<>();
		}
		
		application.setAttribute("userList", userList);
		
		return "ex-16";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/post")
	public String input(String name, String comment) {
		
		User user = new User();
		user.setName(name);
		user.setComment(comment);
		
		List<User> userList = (List<User>) application.getAttribute("userList");
		
		userList.add(0, user);
		
		// 上記でapplicationスコープ内にあるuserListに追加しているので
		// 再度以下の行のようにapplicationスコープを上書きする必要無し
		// application.setAttribute("userList", userList); 

		// 投稿後、更新ボタンを押した際に再度投稿されてしまう現象をリダイレクトで防ぐ
		return "redirect:/ex16";
	}

}
