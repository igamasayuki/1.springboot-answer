package com.example.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 性別を表す列挙型.
 * 
 * @author igamasayuki
 *
 */
public enum GenderEnum {
	// 定数一覧、DayOfWeekのコンストラクタを使用
	MAN(1, "男"), WOMAN(2, "女"),;

	// 定数に含めるフィールド、コンストラクタ、メソッドを定義
	/** key値 */
	private final Integer key;
	/** value値 */
	private final String value;

	/**
	 * コンストラクタ。
	 */
	private GenderEnum(final Integer key, final String value) {
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
	public static GenderEnum of(Integer key) {
		for (GenderEnum genderEnum : GenderEnum.values()) {
			if (genderEnum.key == key) {
				return genderEnum;
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
		for (GenderEnum genderEnum : GenderEnum.values()) {
			map.put(genderEnum.key, genderEnum.value);
		}
		return map;
	}

}
