package com.ss.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.security.entity.Users;
import com.ss.security.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// 만약 2개 이상의 url을 이용해서 처리하고 싶을 경우
	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user"; // html 뷰페이지로 이동
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	// 메서드에서 접근 권한을 설정
	@PreAuthorize("hasRole('ROLE_MANAGER')") // 메서드 실행 전 권한 확인
	@PostAuthorize("hasRole('ROLE_MANAGER')") // 메서드 실행 후 권한 확인
	@Secured("ROLE_MANAGER")
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		return "manager";
	}
	
	// 스프링 시큐리티 해당하는 주소를 낚아챈다. 그래서 무조건 로그인을 할 수 있도록 페이지를 여기로 가져온다.
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginPro")
	public String loginPro() {
		return "login";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	// 회원가입 시 처리가 끝나면 / → index 페이지로 이동할 수 있도록 redirect
	@PostMapping("/joinPro")
	public String joinPro(Users user) {
		log.info("회원가입 진행: " + user);
		
		// 입력 받은 비밀번호를 먼저 꺼낸다.
		String inputPw = user.getPassword();
		
		// 암호화
		String encPw = encoder.encode(inputPw);
		log.info("암호화: " + encPw);
		
		// 다시 저장한다.
		user.setPassword(encPw);
		
		// 역할을 지정한다.
		user.setRole("ROLE_USER");
		
		// sql에 저장한다.
		repo.save(user);
		
		// 새로운 요청으로 메인 페이지 이동
		return "redirect:/";
	}
}
