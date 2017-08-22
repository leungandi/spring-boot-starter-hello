package com.szl.spring_boot_starter_hello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * HelloConfig
 * 
 * 模拟实现简单的springboot的自动配置
 * 
 * 在application.properties中配置的前缀是spring.hello
 * 默认显示字符是“world(默认显示字符)”,可以通过spring.hello.msg=""进行指定
 * 
 *
 */
@ConfigurationProperties(prefix="spring.hello")
public class HelloConfig {
   
	private static final String MSG = "world(默认显示字符)";
	
	private String msg = MSG;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
