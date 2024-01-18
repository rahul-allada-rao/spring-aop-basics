package com.arr.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
// the purpose of explicitly stating this annotation @EnableAspectJAutoProxy is to clarify intent of using AOP
//@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableAspectJAutoProxy
@ComponentScan("com.arr.aop")
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
