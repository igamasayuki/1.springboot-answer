package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.constant.GenderEnum;
import com.example.constant.HobbyEnum;
import com.example.constant.LanguageEnum;
import com.example.domain.Questionnaire;
import com.example.form.Ex17QuestionnaireForm;

/**
 * アンケート関連コントローラ.<br>
 * Enumを使用したサンプルです。
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/ex17-enum")
public class Ex17QuestionnaireController2 {

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
	 * Enum を使う場合のサンプル
	 *
	 * @param model モデル
	 * @param form  フォーム
	 * @return アンケート登録
	 */
	@GetMapping("")
	public String index(Model model, Ex17QuestionnaireForm form) {
		// 選択肢を含む各Enum から Mapを作成しリクエストスコープに格納
		// 性別
		model.addAttribute("genderMap", GenderEnum.getMap());
		// 趣味
		model.addAttribute("hobbyMap", HobbyEnum.getMap());
		// 好きな言語
		model.addAttribute("languageMap", LanguageEnum.getMap());

		return "ex-17-input-enum";
	}

	/**
	 * アンケート登録.<br>
	 * Enum を使う場合のサンプル
	 *
	 * @param form               フォーム
	 * @param result             リザルト
	 * @param redirectAttributes フラッシュスコープに対応したmodel
	 * @return 入力確認画面(リダイレクト)
	 */
	@PostMapping(value = "/create")
	public String create(@Validated Ex17QuestionnaireForm form, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return index(model, form);
		}
		Questionnaire questionnaire = new Questionnaire();
		BeanUtils.copyProperties(form, questionnaire);
		// 性別
		// Enum数値を実際の値へ変換 (例) gender 1 ⇒男
		questionnaire.setGender(GenderEnum.of(form.getGender()).getValue());

		// 趣味
		List<String> hobbyList = new ArrayList<String>();
		for (Integer hobbyKey : form.getHobbyList()) {
			String strHobby = HobbyEnum.of(hobbyKey).getValue();
			hobbyList.add(strHobby);
		}
		questionnaire.setHobbyList(hobbyList);

		// 好きな言語
		questionnaire.setLanguage(LanguageEnum.of(form.getLanguage()).getValue());

		redirectAttributes.addFlashAttribute("questionnaire", questionnaire);
		return "redirect:/ex17-enum/toresult";
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
