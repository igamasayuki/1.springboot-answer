package com.example.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 好きな言語を表す列挙型.
 * 
 * @author igamasayuki
 *
 */
public enum LanguageEnum {
	// 定数一覧、DayOfWeekのコンストラクタを使用
	JAVA(1, "Java"), PHP(2, "PHP"), PYTOHN(3, "Python"), RUBY(4, "Ruby"),;

	// 定数に含めるフィールド、コンストラクタ、メソッドを定義
	/** key値 */
	private final Integer key;
	/** value値 */
	private final String value;

	/**
	 * コンストラクタ。
	 */
	private LanguageEnum(final Integer key, final String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 定数に含まれるvalue値を返します。
	 * 
	 * @return value値
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 定数に含まれるkey値を返します。
	 * 
	 * @return key値
	 */
	public Integer getKey() {
		return key;
	}

	/**
	 * keyからenumを取得
	 * 
	 * @param key
	 *            key
	 * @return 渡されたkeyを含むenum
	 */
	public static LanguageEnum of(Integer key) {
		for (LanguageEnum languageEnum : LanguageEnum.values()) {
			if (languageEnum.key == key) {
				return languageEnum;
			}
		}
		throw new IndexOutOfBoundsException("The value of enum doesn't exist.");
	}
	
	/**
	 * enumからMap<key,value>を作成し、返します.
	 * 
	 * @return Mapオブジェクト
	 */
	public static Map<Integer,String> getMap() {
		Map<Integer,String> map = new LinkedHashMap<>();
		for (LanguageEnum languageEnum : LanguageEnum.values()) {
			map.put(languageEnum.key, languageEnum.value);
		}
		return map;
	}

}
