package com.ss.aop.ex.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExStringAspect {
	// args(param)
	// 특정 타입의 인자가 전달된 메서드에만 어드바이스를 적용한다.
	// 매개변수 이름, 타입, 매개변수 순서 일치해야 된다.
	@Before("execution(* com.ss.aop.ex.controller.ExService.doSome(..)) && args(param)")
	public void stringEx(String param) {
		System.out.println("aspect 전송:" + param);
	}

	@After("execution(* com.ss.aop.ex.controller.ExService.doSome(..)) && args(param,num)")
	public void stringEx2(String param, int num) {
		System.out.println("aspect1번전송:" + param + "2번전송:" + num);
	}
}