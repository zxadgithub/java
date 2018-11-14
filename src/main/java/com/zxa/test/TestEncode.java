package com.zxa.test;

import java.net.URLEncoder;

/**
 * @ClassName: TestEncode
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/7 16:04
 */
public class TestEncode {
	public static void main(String[] args) {
		String params = "{" +
				"    \"params\": {" +
				"  \"agentId\": \"1234\"," +
				"        \"rewardStatus\": \"1\"" +
				"    }" +
				"}";
		String urlPrams = URLEncoder.encode(params);
		String urlParamLasr = urlPrams.replace("+","%20");
		System.out.println(urlParamLasr);
	}
}
