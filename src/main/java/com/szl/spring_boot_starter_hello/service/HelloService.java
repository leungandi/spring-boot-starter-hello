package com.szl.spring_boot_starter_hello.service;


/**
 * HelloConfig
 * 
 * 模拟实现简单的springboot的自动配置
 *
 */
public class HelloService {
   
	
	private String msg;
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String SayHello() {
		return "Hello"+getMsg();
	}

	
	
	
}
