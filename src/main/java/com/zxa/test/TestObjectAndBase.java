package com.zxa.test;

/**
 * @ClassName: TestObjectAndBase
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/23 9:36
 */
public class TestObjectAndBase {

	public static void main(String[] args) {
		int i = 3;
		updateInt(i);

		User user = new User();
		user.setName("zxa");
		updateObject(user);

	}

	private static void updateObject(User user) {
		user.setName("zxa!");
	}

	private static void updateInt(int i) {
		i = 5;
	}

	static  class User{
		private String name;
		private Integer age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
	}

}



