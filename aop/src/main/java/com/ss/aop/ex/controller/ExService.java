package com.ss.aop.ex.controller;

import org.springframework.stereotype.Service;

import com.ss.aop.it.dto.Employee;

@Service
public class ExService {
	// 매개변수로 문자열을 받는 메서드
	public void doSome(String input, int num) {
		System.out.println("ExService " + input + " 처리중1 ..");
		System.out.println("ExService " + num + " 처리중2 ..");
	}
	
	public void doEmployee(Employee em) {
		// aspect 실행 시 출력하는 Before() 실행
		System.out.println("service: " + em.getName());
	}
}
