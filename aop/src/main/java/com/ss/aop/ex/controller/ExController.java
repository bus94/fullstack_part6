package com.ss.aop.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.aop.it.dto.Employee;

@Controller
public class ExController {
	@Autowired
	private ExService service;
	@Autowired
	private Employee employee;
	
	// 특정 메서드가 실행될 때
	// 매개변수로 전달된 문자열을 가로채서 출력하는 aspect 설정
	@GetMapping("/ex")
	public String ex() {
		service.doSome("Hello!", 10);
		return "aop1";
	}
	
	@GetMapping("/ex2")
	public String ex2() {
		employee.setName("익준");
		service.doEmployee(employee);
		return "aop1";
	}
}
