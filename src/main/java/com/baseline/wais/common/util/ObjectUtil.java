package com.baseline.wais.common.util;

import org.springframework.beans.BeanUtils;

public class ObjectUtil {
	
	public static boolean isNull(Object obj) {
		return obj == null;
	}
	
	public static boolean isNotNull(Object obj) {
		return obj != null;
	}
	
	public static void mapObject(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}

}
