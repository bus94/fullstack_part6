package com.ss.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

/*
 * 엔티티 Member
 * no 고유식별번호
 * id varchar(100)
 * pw varchar(100)
 * name, email, 회원가입날짜(createAt), 주소, 폰번호
 * 	
 * 필수적으로 아이디(중복x), 패스워드, 주소, 폰번호
 * 
 * 컨트롤러, 서비스, JPA 설정
 * 
 * DB명 ShoppyDB
 * 테이블명 Product
 * 제품명, 가격, 카테고리, 제품설명, 브랜드(옵션)
 * 이미지 URL
 *  
 */
