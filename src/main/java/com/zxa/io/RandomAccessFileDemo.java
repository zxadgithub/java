package com.zxa.io;

import com.zxa.utils.PathUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;

/**
 * @ClassName: RandomAccessFileDemo
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/8 10:55
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) {
		URL url = PathUtil.getResource(RandomAccessFileDemo.class);
		System.out.println("当前路径：" + url.getFile());
		RandomAccessFile randomAccessFile = null;
		RandomAccessFileDemo randomAccessFileDemo = new RandomAccessFileDemo();
		try {
			randomAccessFile = new RandomAccessFile(url.getFile() + "employee.txt", "rw");
			randomAccessFileDemo.write(randomAccessFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			randomAccessFile = new RandomAccessFile(url.getFile() + "employee.txt", "rw");
			randomAccessFileDemo.read(randomAccessFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void read(RandomAccessFile randomAccessFile) {
		try {
			randomAccessFile.skipBytes(12);
			System.out.println("第二个员工信息：");
			printInfo(randomAccessFile);
			randomAccessFile.seek(0);
			System.out.println("第一个员工的信息");
			printInfo(randomAccessFile);
			randomAccessFile.skipBytes(12);
			System.out.println("第三个员工的信息");
			printInfo(randomAccessFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printInfo(RandomAccessFile randomAccessFile) throws IOException {
		String str = "";
		for (int i = 0; i < 8; i++) {
			str = str + (char) randomAccessFile.readByte();
		}
		System.out.println("name:" + str);
		System.out.println("age:" + randomAccessFile.readInt());
	}

	public void write(RandomAccessFile randomAccessFile) {
		Employee e1 = new Employee("zhangsan", 23);
		Employee e2 = new Employee("lisi", 24);
		Employee e3 = new Employee("wangwu", 25);


		try {

			randomAccessFile.writeBytes(e1.getName());
			randomAccessFile.writeInt(e1.getAge());
			randomAccessFile.writeBytes(e2.getName());
			randomAccessFile.writeInt(e2.getAge());
			randomAccessFile.writeBytes(e3.getName());
			randomAccessFile.writeInt(e3.getAge());

			System.out.println("成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				randomAccessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Employee {
	private String name;
	private int age;
	private final static int LEN = 8;

	public Employee() {

	}

	public Employee(String name, int age) {
		if (name.length() > LEN) {
			name = name.substring(0, 8);
		} else {
			while (name.length() < LEN) {
				name = name + "\u0000";
			}
		}
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
