package com.zxa.classloader;

import java.io.*;

/**
 * @ClassName: PathClassLoader
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/14 18:44
 */
public class ClassReLoader extends ClassLoader {

	private String classPath;
	String className = "com.zxa.test.TestArrayCopy";

	public ClassReLoader(String path){
		this.classPath = path;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getData(name);
		if (classData == null){
			throw new ClassNotFoundException();
		}else {
			return defineClass(className, classData, 0, classData.length);
		}

	}

	private byte[] getData(String name) {
		String path = classPath + name;
		try {
			InputStream is = new FileInputStream(path);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			byte[] buffer = new byte[2048];
			int num = 0;
			while ((num = is.read(buffer)) != -1){
				stream.write(buffer,0,num);
			}
			return stream.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try{
			String path = "C:\\My\\Studys\\java\\target\\classes\\com\\zxa\\test\\";
			ClassReLoader reLoader = new ClassReLoader(path);
			Class r = reLoader.findClass("TestArrayCopy.class");
			System.out.println(r.newInstance());
			ClassReLoader reLoader1 = new ClassReLoader(path);
			//Exception in thread "main" java.lang.LinkageError
//			Class r1 = reLoader.findClass("TestArrayCopy.class");
			Class r1 = reLoader1.findClass("TestArrayCopy.class");
			System.out.println(r1.newInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

}
