package com.ss.firstproject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.firstproject.dto.User;

@Controller
public class FirstController {
	// 브라우저에서 url "hi"라는 요청이 들어오면 메서드 실행될 수 있도록 하기
	@GetMapping("hi")
	public String hi(Model model) {
		// Model 인터페이스 객체에 addAttribute
		// 실행하면 viewPage로 넘겨줄 데이터를 넣어준다.
		model.addAttribute("username", "홍길동");

		// 뷰페이지 이름
		return "hi";
	}

	@GetMapping("/main.do")
	public String mainPage(Model model) {
		model.addAttribute("nickname", "haha 호호");
		return "main";
	}

	@GetMapping("/list.do")
	public String list(Model model) {
		List<String> items = Arrays.asList("사과", "바나나", "체리");
		model.addAttribute("items", items);
		return "list";
	}

	@GetMapping("/object.do")
	public String object(Model model) {
		User user = new User();
		user.setId("qwer");
		user.setEmail("qwer@g.com");

		model.addAttribute("user", user);
		return "object";
	}

	@GetMapping("/objList.do")
	public String objList(Model model) {
		List<User> users = new ArrayList<User>();
		users.add(new User("Alice", "alice@example.com"));
		users.add(new User("Bob", "bob@example.com"));
		users.add(new User("Charlie", "charlie@example.com"));
		users.add(new User("David", "david@example.com"));
		users.add(new User("Eve", "eve@example.com"));

		model.addAttribute("users", users);
		return "objList";
	}

}

/*
 * Mustache 템플릿 spring boot에서 컨트롤러에서 데이터를 전달 Mustache가 받아서 데이터를 웹 페이지에 출력하는 기본적인
 * 방법
 * 
 * 기본적인 설정은 application.properties 1. server.port 설정 2. 한글 깨질 수 있으니 인코딩 설정
 * server.servlet.encoding.force=true 기입! 서버에서 모든 요청 및 응답이 들어오면 전부 한글 깨짐을 적용시킨다.
 * 
 * mustache 1. 주석 {{!}}
 * 
 * 
 */
