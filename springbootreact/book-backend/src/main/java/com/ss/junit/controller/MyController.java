package com.ss.junit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// MockMvc
// - 웹 컨트롤러의 서버를 실행하지 않고, 테스트할 수 있도록 도와주는 라이브러리

@RestController // 데이터 반환 json 또는 문자열
public class MyController {
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, world!";
	}
	
	// ResponseEntity<? extends 클래스명, 인터페이스명> : 와일드 카드 (상속을 받게 되면 제약을 줄 수 있다)
	
	@PostMapping("/create")
	public ResponseEntity<String> create() {
		// 단순히 created 문자를 반환
		return ResponseEntity.ok("created");
		// return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id) {
		return ResponseEntity.ok("updated");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.ok("deleted");
	}
}
