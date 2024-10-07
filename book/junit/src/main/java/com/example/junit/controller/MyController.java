package com.example.junit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.junit.entity.Member;

// MockMvc 
//  - 웹 컨트롤러의 서버를 실행하지 
//    않고 테스트할 수있도록 도와주는
//    라이브러리 
//  - 통합테스트, 컨트롤러 테스트할 때
//    유용하게 사용됨


@RestController //데이터반환 json또는 문자열
public class MyController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, world!";
	}
	
	// ResponseEntity<? extends 클래스명,인터페이스명> 
	// 와일드 카드!
	
	@PostMapping("/create")
	public ResponseEntity<String> create(){
		//단순히 created 문자를 반환
		return ResponseEntity.ok("created");
		 // new ResponseEntity<>(body,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String>
					update(@PathVariable Long id){
		
		return ResponseEntity.ok("updated");
	}
	
	
	
	
	
}
