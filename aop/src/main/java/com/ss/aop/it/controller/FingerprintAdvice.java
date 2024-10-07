package com.ss.aop.it.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ss.aop.it.dto.Employee;


@Aspect
@Component
public class FingerprintAdvice {
	// 아침에 지문 인증을 할 수 있도록!
	// execution() 어디 메서드를 가로챌지 결정하는 부분!
	// within() : 클래스 내부에 속한 메서드에만 어드바이스가 적용될 수 있도록 범위를 제한하는 메서드
//	@Before("* execution(com.ss.aop.it.dto.Employee.work(..)) && target(em) && within(com.ss.aop.it.dto.Department)")
	// 개발팀만 지문인증을 할 수 있도록 설정!
	@Before("execution(* com.ss.aop.it.dto.Employee.work(..))")
	public void fingerCheck() {
		System.out.println("출근 지문 완료!");
	}
	
	// 위의 내용 중 전체 직원 중에서 택시비를 지원하는 직원은 총 6명이다.
	// 이때 aspect를 어떻게 끼워넣는게 좋을지 고민해보기!
	@After("execution(* com.ss.aop.it.dto.Employee.work(..)) && args(em)")
	public void taxiCheck(Employee em) {
		System.out.println("em: " + em);
		// 1시간 이상되는 직원들의 정보를 받아야된다.
		if(isTaxi(em)) {
			System.out.println("택시비 지원한다.");
		} else {
			System.out.println("택시비 지원하지 않는다.");
		}
	}
	
	// 택시비 지원 판단
	private boolean isTaxi(Employee em) {
		return em.getName().equals("홍길동");
	}
	
	
}
