package com.ss.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ss.article.dto.UserDTO;
import com.ss.article.entity.User;
import com.ss.article.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UsersController {
	
	@Autowired
	private UsersRepository userSql;
	
	// 1. getMapping("/users/new")
	// 		회원가입 하는 페이지
	// 		id varchar 문자 String
	//		name , birthday , phone 
	// 		form태그를 이용해서 input
	
	// 2. PostMapping("/users/create)
	// 		dto, package com.ss.article.repository;
	// public interface UsersRepository {
	// 		상속 받아 엔티티 타입과 기본키 타입 제네릭으로 매개변수를 넘겨준다.
	// }
	
	// 3. 엔티티 선언하고 어노테이션 달기
	// 4. 컨트롤러에서 자바 객체를 엔티티로 변환하기
	// 5. 전송(save)
	
	@GetMapping("/users/new")
	public String newUsers() {
		
		return "/users/new";
	}
	
	@PostMapping("/users/create")
	public String createUsers(UserDTO dto) {
		dto.setId(1L);
		User user = dto.toEntity();
		
		User result = userSql.save(user);
		log.info("결과값: " + result);
		
		return "/users/new";
	}
}
