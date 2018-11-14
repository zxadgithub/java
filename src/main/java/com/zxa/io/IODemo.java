package com.zxa.io;

import com.zxa.utils.PathUtil;

import java.io.*;


/**
 * @ClassName: IODemo
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/8 14:42
 */
public class IODemo {
	public static void main(String[] args) throws IOException {
		String fileName = PathUtil.getResource(IODemo.class).getFile() + "stream.txt";
		File file = new File(fileName);
//		writeStream(file);
//		readStream(file);
		String fileName1 = PathUtil.getResource(IODemo.class).getFile() + "string.txt";
		File file1 = new File(fileName1);
		WRString(file1);
	}

	private static void WRString(File file1) {
		try (
				Writer writer = new FileWriter(file1);
		) {

			writer.write("Hello World !　This is a test !");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (
				Reader reader = new FileReader(file1);
		) {
			char[] chars = new char[8];
			while( reader.read(chars) != -1){

				System.out.print(new String(chars));
				chars = new char[8];
			}
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readStream(File file) throws IOException {
		InputStream inputStream = null;
		try {
		inputStream = new FileInputStream(file);
		byte [] bytes = new byte[(int)file.length()];
		int i = 0;
		i = inputStream.read(bytes);
			System.out.println(i);
			System.out.println(new String(bytes,0,i));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void writeStream(File file) throws IOException {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			byte[] b = "Hello Word!".getBytes();
			outputStream.write(b);
			System.out.println("Successful!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			outputStream.close();
		}
	}
}
