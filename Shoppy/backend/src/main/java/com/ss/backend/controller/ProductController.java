package com.ss.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.backend.entity.Member;
import com.ss.backend.entity.Product;
import com.ss.backend.service.MemberService;
import com.ss.backend.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {
	// 실제 시큐리티로 들어온 자격증명을 해주는 핵심 인터페이스!
	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private ProductService productService;

	@Autowired
	private MemberService memberService;

	// 모든 상품 불러오기
	@GetMapping("/products")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}

	// 상품 등록하기
	@PostMapping("/products")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
	}

	// 회원가입 시에 비밀번호 보내기
	@PostMapping("/products/register")
	public ResponseEntity<String> register(@RequestBody Member member) {
		System.out.println("member:" + member);
		memberService.register(member);
		return ResponseEntity.ok("회원가입");
	}

	// 로그인
	@PostMapping("/products/login")
	public String login(@RequestBody Member member) {
		System.out.println("레스트컨트롤러");
		System.out.println("member: " + member);

		try {
			// 비밀번호랑 이메일을 인증
			// authenticate(null) 사용자가 입력한 이메일과 비밀번호가 맞는지 확인하는 메서드
			Authentication auth = manager
					.authenticate(new UsernamePasswordAuthenticationToken(member.getEmail(), member.getPassword()));
			System.out.println("인증시도함: " + auth);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "로그인 실패!" + e.getMessage();
		}

		return "로그인 성공!";
	}

}
