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
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/")
public class Ex17QuestionnaireController {

	/**
	 * フォームの初期化.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public Ex17QuestionnaireForm setUpForm() {
		return new Ex17QuestionnaireForm();
	}

	/**
	 * アンケート入力画面表示.<br>
	 * 
	 * @param model
	 *            モデル
	 * @return アンケート登録
	 */
	@RequestMapping(value = "/ex17")
	public String index(Model model) {
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
	@RequestMapping(value = "/create")
	public String create(@Validated Ex17QuestionnaireForm form, BindingResult result, RedirectAttributes redirectAttributes,
			Model model) {

		if (result.hasErrors()) {
			return index(model);
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
		return "redirect:/toresult";
	}

	/**
	 * 入力確認画面表示.
	 * 
	 * @return 入力確認画面
	 */
	@RequestMapping(value = "/toresult")
	public String toresult() {
		return "ex-17-result";
	}

	// /**
	// * アンケート入力画面表示.<br>
	// * Enum を使う場合のサンプル
	// *
	// * @param model
	// * モデル
	// * @return アンケート登録
	// */
	// @RequestMapping("/")
	// public String index(Model model) {
	// Map<Integer, String> genderMap = new LinkedHashMap<Integer, String>();
	// genderMap.put(GenderEnum.MAN.getKey(), GenderEnum.MAN.getValue());
	// genderMap.put(GenderEnum.WOMAN.getKey(), GenderEnum.WOMAN.getValue());
	// model.addAttribute("genderMap", genderMap);
	//
	// Map<Integer, String> hobbyMap = new LinkedHashMap<Integer, String>();
	// hobbyMap.put(HobbyEnum.TENNIS.getKey(), HobbyEnum.TENNIS.getValue());
	// hobbyMap.put(HobbyEnum.BASE_BALL.getKey(),
	// HobbyEnum.BASE_BALL.getValue());
	// hobbyMap.put(HobbyEnum.GOLF.getKey(), HobbyEnum.GOLF.getValue());
	// model.addAttribute("hobbyMap", hobbyMap);
	//
	// Map<Integer, String> languageMap = new LinkedHashMap<Integer, String>();
	// languageMap.put(LanguageEnum.JAVA.getKey(),
	// LanguageEnum.JAVA.getValue());
	// languageMap.put(LanguageEnum.PHP.getKey(), LanguageEnum.PHP.getValue());
	// languageMap.put(LanguageEnum.PYTOHN.getKey(),
	// LanguageEnum.PYTOHN.getValue());
	// languageMap.put(LanguageEnum.RUBY.getKey(),
	// LanguageEnum.RUBY.getValue());
	// model.addAttribute("languageMap", languageMap);
	//
	// return "input";
	// }
	//
	// /**
	// * アンケート登録.<br>
	// * Enum を使う場合のサンプル
	// *
	// * @param form
	// * フォーム
	// * @param result
	// * リザルト
	// * @param redirectAttributes
	// * フラッシュスコープに対応したmodel
	// * @return 入力確認画面(リダイレクト)
	// */
	// @RequestMapping(value = "create")
	// public String create(@Validated QuestionnaireForm form, BindingResult
	// result, RedirectAttributes redirectAttributes,
	// Model model) {
	// if (result.hasErrors()) {
	// return index(model);
	// }
	// Questionnaire questionnaire = new Questionnaire();
	// BeanUtils.copyProperties(form, questionnaire);
	// // Enum数値を実際の値へ変換 (例) gender 1 ⇒男
	// questionnaire.setGender(GenderEnum.of(form.getGender()).getValue());
	// List<String> hobbyList = new ArrayList<String>();
	// for (Integer hobbyKey : form.getHobbyList()) {
	// String strHobby = HobbyEnum.of(hobbyKey).getValue();
	// hobbyList.add(strHobby);
	// }
	// questionnaire.setHobbyList(hobbyList);
	// questionnaire.setLanguage(LanguageEnum.of(form.getLanguage()).getValue());
	// redirectAttributes.addFlashAttribute("questionnaire", questionnaire);
	// return "redirect:/toresult";
	// }
}
