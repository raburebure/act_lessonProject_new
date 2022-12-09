package codeList;

public enum Authority {

	GENERAL("なし", 0), ADMIN("あり", 1);

	private String label;
	private int value;

	//コンストラクタはprivateで宣言
	private Authority(String label, int value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}

	/**
	 * 指定した値に合致するラベル名を返す
	 * @param value
	 * @return
	 */
	public static String convertLabel(int value) {
		Authority[] array = values();
		for (Authority num : array) {
			if (value == num.getValue()) {
				return num.getLabel();
			}
		}
		return null;
	}
}