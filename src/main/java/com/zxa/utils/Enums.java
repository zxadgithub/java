package com.zxa.utils;

import java.util.Random;

/**
 * @ClassName: Enums
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/29 9:43
 */
public class Enums {
	private static Random rand = new Random();
	public static <T extends Enum<T>> T random(Class<T> ec){
		return random(ec.getEnumConstants());
	}

	public static <T> T random(T[] values){
		return values[rand.nextInt(values.length)];
	}

}

