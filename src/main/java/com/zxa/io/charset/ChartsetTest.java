package com.zxa.io.charset;



import com.carrotsearch.hppc.CharSet;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @ClassName: ChartsetTest
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/20 15:34
 */
public class ChartsetTest {
	public static void main(String[] args) {
		String  s = "这是一段中文字符串";
		byte[] b = null;
		try {
			b = s.getBytes("UTF-8");
			for(byte a : b){
				System.out.println(a);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(new java.lang.String(b,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Charset charset = Charset.forName("UTF-8");
		ByteBuffer byteBuffer = charset.encode(s);
		System.out.println(byteBuffer);
		CharBuffer charBuffer = charset.decode(byteBuffer);
	}
}
