package com.zxa.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: WebApplication
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/11 17:02
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.zxa.*")
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class);
	}
}
