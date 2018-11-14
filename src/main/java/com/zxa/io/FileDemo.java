package com.zxa.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName: File
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/8 10:01
 */
public class FileDemo {
	public static void main(String[] args) {
		new FileDemo().operate();
	}

	private void operate() {
		URL url  = FileDemo.class.getResource("/");
		File file = new File(url.getFile());
		if( existAndIsDir(file)){
			System.out.println( file + "是一个文件夹");
			File[] files = file.listFiles();
			System.out.println("当前路径下所有的文件");
			for(File f : files){
				System.out.println( f + "\t");
			}
			System.out.println();

			System.out.println(" files[0] 的文件名 ："  + files[0].getName());
			System.out.println(" files[0] 的文件路径：" + files[0].getPath());
			System.out.println("files[0]的绝对路径：" + files[0].getAbsolutePath());
			System.out.println("files[0]的父文件夹 " + files[0].getParent());
			System.out.println("canWrite" + files[0].canWrite());
			System.out.println("canRead" + files[0].canRead());
			System.out.println("canExecute" + files[0].canExecute());
			System.out.println("是否目录" + files[0].isDirectory());
			System.out.println("说=是否文件：" + files[0].isFile());
			System.out.println("最后修改时间：" + files[0].lastModified());
			System.out.println("文件大小：" + files[0].length());
			System.out.println("文件URI:" + files[0].toURI());

			File file1 = new File(url.getFile()+"test.txt");
			try {
				file1.createNewFile();
				System.out.println("创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
			file1.delete();

		}
	}

	private boolean existAndIsDir(File file) {
		return file.exists() && file.isDirectory();
	}


}
