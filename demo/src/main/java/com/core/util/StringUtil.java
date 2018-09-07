package com.core.util;

public class StringUtil {

	
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
	
	
	public static boolean isEmptyTrim(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public static String toLowerCase(String string) {
		if (isEmpty(string)) {
			return string;
		}
		return string.toLowerCase();
	}
	
	public static String toUpperCase(String string) {
		if (isEmpty(string)) {
			return string;
		}
		return string.toUpperCase();
	}
	
	
	
	
	
}
