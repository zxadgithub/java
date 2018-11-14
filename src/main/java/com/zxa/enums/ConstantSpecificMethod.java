package com.zxa.enums;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ConstantSpecificMethod
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/29 20:57
 */
public enum ConstantSpecificMethod {

	DATE_TIME{
		String getInfo(){
			System.out.println("teset");
			return DateFormat.getDateInstance().format(new Date()) + "test";
		}
	};





	abstract String getInfo();

	public static void main(String[] args) {
		for(ConstantSpecificMethod specificMethod : values()){
			specificMethod.getInfo();
		}
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		executorService.submit(() -> DATE_TIME.getInfo());
	}
}
