package com.ss.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@GetMapping("/member")
	public String memberMain() {
		log.info("메인 페이지 memberMain() 실행");
		return "aop";
	}
}
