package com.ss.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.junit.entity.Member;
import com.ss.junit.service.MemberService;

@CrossOrigin
@RequestMapping("/member")
@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/join")
	public ResponseEntity<?> joinMember(@RequestBody Member member) {
		return new ResponseEntity<Member>(memberService.저장하기(member), HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(memberService.가져오기(), HttpStatus.OK);
	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<String> loginMember(@RequestBody Member loginData) {
		Member member = memberService.login(loginData);
		// loginForm 페이지로 이동할 수 있도록 설정
		if(member != null) {
			return ResponseEntity.ok("로그인 성공!");
		}
		return ResponseEntity.status(401).body("로그인 실패!");
	}
}
