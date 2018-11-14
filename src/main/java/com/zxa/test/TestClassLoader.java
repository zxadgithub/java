package com.zxa.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TestClassLoader
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/12 15:20
 */
public class TestClassLoader {

	public static void main(String[] args) {
		String path = TestClassLoader.class.getClassLoader().getResource("").toString();
		System.out.println(path);
	}

}


class CastException{
	public static Map m = new HashMap(){{
		m.put("a","2");
	}
	};

	public static void main(String[] args) {
		Integer integer = (Integer) m.get("a");
		System.out.println(integer);
	}
}




class StaticParams {

	private static int NUM_B = getB();
	private static int NUM_A = getA();
	private static List<String> LIST_A = getListA();

	private StaticParams() {
		System.out.println("初始化构造方法");
	}

	public static StaticParams getInstance() {
		return new StaticParams();
	}

	private static int getA() {
		System.out.println("初始化A");
		return 10;
	}

	private static int getB() {
		System.out.println("初始化B");
		System.out.println(LIST_A.size());
		return 20;
	}

	private static List<String> getListA() {
		System.out.println("初始化List");
		return new ArrayList<String>();
	}

	public static void main(String[] args) {
		StaticParams.getInstance();
	}
}
