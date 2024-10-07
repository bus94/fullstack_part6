package com.ss.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}

}

/*
 * 1. 기본 셋팅(메이븐)
 * 2. 타임리프 설정
 * 3. header, footer 하나의 html 파일에 챗봇 디자인 출력할 수 있도록 하기
 * 4. 드라이브 프로젝트 test 안에 본인 폴더 생성 후 만든 프로젝트 올리기
 */