package com.example.sample.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sample.domain.User;
import com.example.sample.form.UserForm;
import com.example.sample.service.UserService;

/**
 * ユーザ情報を操作するコントローラ.
 * 
 * @author igamasayuki
 */
@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * 入力画面を表示する.
	 * 
	 * @param model モデル
	 * @return 入力画面
	 */
	@GetMapping("")
	public String index(Model model, UserForm form) {

		Map<Integer, String> hobbyMap = new LinkedHashMap<>();
		hobbyMap.put(1, "野球");
		hobbyMap.put(2, "サッカー");
		hobbyMap.put(3, "テニス");

		model.addAttribute("hobbyMap", hobbyMap);

		return "user/input";
	}

	/**
	 * ユーザ情報を登録する.
	 * 
	 * @param form               フォーム
	 * @param redirectAttributes flashスコープを使うためのオブジェクト
	 * @return 登録完了画面へリダイレクト
	 */
	@PostMapping("/create")
	public String create(@Validated UserForm form // バリデーションが動くようにアノテーション追加
			, BindingResult result // エラーメッセージが格納されるオブジェクト
			, RedirectAttributes redirectAttributes // flashスコープを使用するための準備
			, Model model // requestスコープを使用するための準備
	) {

		// もしエラーが一つでもあった場合は入力画面に遷移
		if (result.hasErrors()) {
			// 入力画面遷移用のメソッドを呼び入力画面に戻る
			return index(model, form);
		}

		User user = new User();
		// formオブジェクトからuserオブジェクトにプロパティ値をコピー
		BeanUtils.copyProperties(form, user);

		// 上記でコピーされなかったhobbyListプロパティを手動でコピー
		List<String> hobbyList = new ArrayList<>();
		for (Integer hobbyCode : form.getHobbyList()) {
			switch (hobbyCode) {
			case 1:
				hobbyList.add("野球");
				break;
			case 2:
				hobbyList.add("サッカー");
				break;
			case 3:
				hobbyList.add("テニス");
				break;
			}
		}
		user.setHobbyList(hobbyList);

		// 実際の業務処理「ユーザ登録をする」サービスクラスの呼び出し
		UserService userService = new UserService();
		user = userService.save(user);

		// 今回はrequestスコープは使わない
		// model.addAttribute("user", user);
		// 代わりにflashスコープに格納する
		redirectAttributes.addFlashAttribute("user", user);

		// 登録完了画面にフォワードするメソッドにリダイレクト
		return "redirect:/user/toresult";
	}

	/**
	 * 登録完了画面へフォワード.
	 * 
	 * @return 登録完了画面
	 */
	@GetMapping("/toresult")
	public String toresult() {
		// 登録完了画面へフォワード
		return "user/result";
	}

}
