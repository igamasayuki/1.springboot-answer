package com.example.common;

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
	private final int key;
	/** value値 */
	private final String value;

	/**
	 * コンストラクタ。
	 */
	private HobbyEnum(final int key, final String value) {
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
	public int getKey() {
		return key;
	}

	/**
	 * keyからenumを取得
	 * 
	 * @param key
	 *            key
	 * @return 渡されたkeyを含むenum
	 */
	public static HobbyEnum of(int key) {
		for (HobbyEnum hobbyEnum : HobbyEnum.values()) {
			if (hobbyEnum.key == key) {
				return hobbyEnum;
			}
		}
		throw new IndexOutOfBoundsException("The value of enum doesn't exist.");
	}

}
