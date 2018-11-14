package com.zxa.utils;

import java.net.URL;

/**
 * @ClassName: PathUtil
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/8 11:05
 */
public class PathUtil {
	public static URL getResource(Class currentClass){
		return  currentClass.getResource("/");
	}
}
