package com.ss.aop.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {
	// 중복되는 로깅값을 모아놓는 어드바이스 메서드 생성
	
	// 부가적인 기능을 실행하는 명령문
	// 핵심 메서드가 실행하기 전에 실행!
	
	// 어드바이스(Advice)란?
	// : 실제로 부가적인 기능을 구현한 객체 (실제 명령문)
	
	// @Before(target)
	// target: 어떤 컨트롤러 혹은 어떤 서비스가 실행될 때 사용할 지 패키지명을 작성!
//	@Before("target(com.ss.aop.controller.AopMainController)")
//	public void pageMain() {
//		System.out.println("메인 페이지 실행 시작");
//	}
//	
//	@After("target(com.ss.aop.controller.AopMainController)")
//	public void endPageMain() {
//		System.out.println("메인 페이지 실행 끝");
//	}
	
	// 컨트롤러 폴더에 있는 모든 클래스한테 적용할 때 사용하는 방법
	// execution(접근제한자 반환타입 패키지이름.클래스이름.메서드이름(매개변수)) : AOP에서 포인트 컷!
	// → 어떤 메서드에 대해 aop를 적용할 지 결정
	// * : 핵심 메서드 실행 시 반환타입은 신경쓰지 않는다.
	// com.ss.aop.controller..* : 해당 경로의 메서드 실행 시 모든 메서드에 적용한다.
	// (..) : 매개변수의 타입이나 개수를 신경쓰지 않는다.
	@Before("execution(* com.ss.aop.controller..*(..))")
	public void pageMain() {
		System.out.println("메인 페이지 실행 시작");
	}
	
	@Before("execution(* com.ss.aop.controller.AopMainController.aopMain(..))")
	public void beforeAopPage() {
		System.out.println("aopMain() 실행");
	}
	
	@Before("execution(* com.ss.aop.controller.AopMainController.aop2(..))")
	public void beforeAopPage2() {
		System.out.println("aop2() 실행");
	}
	
	// 앞과 뒤에 동시에 실행하고 싶을 때
	// @Around : 메서드 실행 전후 모두에서 작업을 수행할 수 있는 유일한 어드바이스
	@Around("execution(* com.ss.aop.controller..*(..))")
	public Object aroundPage(ProceedingJoinPoint joinPoint) throws Throwable{
		// 처음 실행될 때 시작하는 명령문 작성
		System.out.println("Before method 실행!");
		
		// 메서드 실행하는 부분
		// ProceedingJoinPoint 타겟 메서드에 접근하고 실행 할 수 있는 인터페이스
		// 타겟과 관련된 내용을 가지고 있다.
		// 메서드의 인자 정보, 메서드 이름, 클래스 정보 등을 가지고 올 수 있다.
		// 결과값을 리턴할 수 있도록!
		// 타겟 메서드들의 타입이 다 다를 수 있다.
		Object result = joinPoint.proceed();
		System.out.println("결과: " + result.toString());
		System.out.println("Signature: " + joinPoint.getSignature());
		System.out.println("Target: " + joinPoint.getTarget());
		
		// 나중에 실행될 때 시작하는 명령문 작성
		System.out.println("After method 실행!");
		return "aop";
	}
}
