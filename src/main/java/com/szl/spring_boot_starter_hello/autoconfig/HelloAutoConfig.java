package com.szl.spring_boot_starter_hello.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.szl.spring_boot_starter_hello.config.HelloConfig;
import com.szl.spring_boot_starter_hello.service.HelloService;

/**
 * HelloConfig
 * 
 * 模拟实现简单的springboot的自动配置
 *
 */
@Configuration
//开启属性注入，通过@EnableConfigurationProperties声明，使用@Autowired注入；
@EnableConfigurationProperties(HelloConfig.class)
//当HelloService.class在类路径的条件下
@ConditionalOnClass(HelloService.class)
//当设置spring.hello.msg=enabled的情况下,如果没有设置,默认为tue，条件成立
@ConditionalOnProperty(prefix="spring.hello",value="enabled",matchIfMissing=true)
public class HelloAutoConfig {
	
	@Autowired
	private HelloConfig helloConfig;
	
	//使用JAVA的配置方式配置HelloSerive.class这个Bean
	@Bean
	//当容器中没有这个bean的时候新建bean
	@ConditionalOnMissingBean(HelloService.class)
	public HelloService helloService() {
		HelloService helloService = new HelloService();
		helloService.setMsg(helloConfig.getMsg());
		return helloService;
	}
   

	
	
}
