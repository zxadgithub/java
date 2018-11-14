package com.zxa.test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: TestArrayCopy
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/11 9:29
 */
public class TestArrayCopy {
	public static void main(String[] args) {
		List l = Arrays.asList(1,2,3);

		Object[] o = new Object[2];
		System.out.println(l.toArray());
		System.out.println(l.toArray(o));
		System.out.println(l);
		System.out.println(o);
		o = l.toArray(o);
		System.out.println(o);
		for(Object o1 : o){
			System.out.println(o1);
		}
	}
}
