package com.example.controller;

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

import com.example.domain.Questionnaire;
import com.example.form.Ex17QuestionnaireForm;

/**
 * アンケート関連コントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/ex17")
public class Ex17QuestionnaireController {

	// 別のやり方で実装しているためコメント
//	/**
//	 * フォームの初期化.
//	 * 
//	 * @return フォーム
//	 */
//	@ModelAttribute
//	public Ex17QuestionnaireForm setUpForm() {
//		return new Ex17QuestionnaireForm();
//	}

	/**
	 * アンケート入力画面表示.<br>
	 * 
	 * @param model
	 *            モデル
	 * @param form フォーム
	 * @return アンケート登録
	 */
	@GetMapping(value = "")
	public String index(Model model,Ex17QuestionnaireForm form) {
		Map<Integer, String> hobbyMap = new LinkedHashMap<>();
		hobbyMap.put(1, "野球");
		hobbyMap.put(2, "サッカー");
		hobbyMap.put(3, "テニス");

		model.addAttribute("hobbyMap", hobbyMap);

		Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(1, "男");
		genderMap.put(2, "女");

		model.addAttribute("genderMap", genderMap);

		Map<Integer, String> languageMap = new LinkedHashMap<>();
		languageMap.put(1, "Java");
		languageMap.put(2, "C");
		languageMap.put(3, "Python");

		model.addAttribute("languageMap", languageMap);

		return "ex-17-input";
	}

	/**
	 * アンケート登録.<br>
	 * Enum を使う場合のサンプル
	 *
	 * @param form
	 *            フォーム
	 * @param result
	 *            リザルト
	 * @param redirectAttributes
	 *            フラッシュスコープに対応したmodel
	 * @return 入力確認画面(リダイレクト)
	 */
	@PostMapping(value = "/create")
	public String create(@Validated Ex17QuestionnaireForm form, BindingResult result, RedirectAttributes redirectAttributes,
			Model model) {

		if (result.hasErrors()) {
			return index(model,form);
		}

		Questionnaire questionnaire = new Questionnaire();
		BeanUtils.copyProperties(form, questionnaire);

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

		switch (form.getGender()) {
		case 1:
			questionnaire.setGender("男");
			break;
		case 2:
			questionnaire.setGender("女");
			break;
		}

		switch (form.getLanguage()) {
		case 1:
			questionnaire.setLanguage("Java");
			break;
		case 2:
			questionnaire.setLanguage("C");
			break;
		case 3:
			questionnaire.setLanguage("PHP");
			break;
		}

		questionnaire.setHobbyList(hobbyList);
		redirectAttributes.addFlashAttribute("questionnaire", questionnaire);
		return "redirect:/ex17/toresult";
	}

	/**
	 * 入力確認画面表示.
	 * 
	 * @return 入力確認画面
	 */
	@GetMapping(value = "/toresult")
	public String toresult() {
		return "ex-17-result";
	}

}
