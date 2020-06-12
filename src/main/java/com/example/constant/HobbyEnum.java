package com.example.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 趣味を表す列挙型.
 * 
 * @author igamasayuki
 *
 */
public enum HobbyEnum {
	// 定数一覧、DayOfWeekのコンストラクタを使用
	TENNIS(1, "テニス"), BASE_BALL(2, "野球"), GOLF(3, "ゴルフ"),;

	// 定数に含めるフィールド、コンストラクタ、メソッドを定義
	/** key値 */
	private final Integer key;
	/** value値 */
	private final String value;

	/**
	 * コンストラクタ。
	 */
	private HobbyEnum(final Integer key, final String value) {
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
	public static HobbyEnum of(Integer key) {
		for (HobbyEnum hobbyEnum : HobbyEnum.values()) {
			if (hobbyEnum.key == key) {
				return hobbyEnum;
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
		for (HobbyEnum hobbyEnum : HobbyEnum.values()) {
			map.put(hobbyEnum.key, hobbyEnum.value);
		}
		return map;
	}

}
