package com.mime.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.@SpringBootApplication
 * 		- 用@SpringBootApplication修饰代表这是个Springboot启动类
 * 		- 运行其主方法就会启动tomcat,默认端口是8080
 * 2.@EnableCaching
 * 		- 添加该注解，则是完全控制MVC
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}




