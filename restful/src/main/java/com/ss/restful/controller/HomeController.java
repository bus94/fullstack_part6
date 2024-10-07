package com.ss.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// 뷰 페이지를 출력하는 내용
	@GetMapping("/index.do")
	public String index() {
		return "index";
	}
	
	// member.main 페이지를 호출하는 메서드
	@GetMapping("/member/main.do")
	public String memebrMain() {
		
		return "member/main";
	}
}
