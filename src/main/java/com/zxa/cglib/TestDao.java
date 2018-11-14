package com.zxa.cglib;

/**
 * @ClassName: TestDao
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 20:02
 */
public class TestDao {

	public TestDao(){
		update();
	}

	public void update() {
		System.out.println("method update()");
	}

	public void select() {
		System.out.println("method select()");
	}
}
