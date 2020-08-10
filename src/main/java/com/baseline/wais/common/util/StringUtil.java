package com.baseline.wais.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {
	
	private static final String EMPTY = "";
	
	/**
	 * String value is not empty or not null
	 * @param str String String
	 * @return Boolean
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * String value is null
	 * @param str String String
	 * @return Boolean
	 */
	public static boolean isNull(String str) {
		return str == null;
	}
	
	/**
	 * String value is not null
	 * @param str String String
	 * @return Boolean
	 */
	public static boolean isNotNull(String str) {
		return str != null;
	}
	
	public static boolean isNotEqualIgnoreCase(String str1, String str2) {
		return !isEqualIgnoreCase(str1, str2);
	}
	
	public static boolean isEqualIgnoreCase(String str1, String str2) {
		
		if(isEmpty(str1) && isEmpty(str2)) {
			return Boolean.TRUE;
		}
		
		return isNotEmpty(str1) && isNotEmpty(str2) && str1.equalsIgnoreCase(str2);
	}
	
	public static boolean isNotEqual(String str1, String str2) {
		return !isEqual(str1, str2);
	}
	
	public static boolean isEqual(String str1, String str2) {
		
		if(isEmpty(str1) && isEmpty(str2)) {
			return Boolean.TRUE;
		}
		
		return isNotEmpty(str1) && isNotEmpty(str2) && str1.equals(str2);
	}
	
	public static String concat(String ...strings) {
		
		String value = EMPTY;
		if(strings != null) {
			for(String str : strings) {
				if(isNotEmpty(str)) {
					value = value.concat(str);
				}
			}
		}
		
		return value;
	}
	
	private static BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static String bCryptPassword(String password) {
		return bCryptPasswordEncoder().encode(password);
	}

}
