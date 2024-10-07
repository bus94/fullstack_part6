package com.ss.aop.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.aop.it.dto.Employee;

@Controller
public class ItController {
	@Autowired
	private Employee em;
	
	// 택시비를 지원하는 객체를 생성
	// 택시비 지원 대상의 이름을 작성
//	List<String> nameList = ["홍길동"];
	
	@GetMapping("/it/index")
	public String index() {
		em.setName("홍길동");
		em.setDepartment("개발팀");
		em.work(this.em);
		
		return "aop1";
	}
	
	
	/*
	 * 어떤 주제를 가지고 어떤 회의를 하느냐에 따라서 필요한 인원들이 달라진다.
	 * 프로그램에서 관점! (aspect)
	 * 
	 * 
	 * 
	 */
}
