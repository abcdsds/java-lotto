package com.woowahan.calculator;

public class ValidationUtil {

	static final String MSG_NOT_A_NUMBER_OR_NEGATIVE = "숫자 이외의 값 또는 음수가 전달되었습니다.";

	static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	static void checkNotANumberAndNegative(String value) {
		if (isNotNumber(value) || isNegative(value)) {
			throw new RuntimeException(MSG_NOT_A_NUMBER_OR_NEGATIVE);
		}
	}

	private static boolean isNegative(String value) {
		int num = Integer.parseInt(value);
		return num < 0;
	}

	private static boolean isNotNumber(String value) {
		try {
			Integer.parseInt(value);
		} catch (Exception e) {
			return true;
		}
		return false;
	}
}