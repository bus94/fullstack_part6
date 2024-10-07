package com.ss.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

}

/*
 * 서블릿
 * - 클라이언트 요청을 처리하고 결과를 반환하는 웹 프로그래밍 기술(자바)
 * - 서블릿 컨테이너의 특징
 * 	 서블릿 객체를 생성, 초기화, 호출, 종료의 생명 주기를 관리
 * - 서블릿 객체는 싱글톤 패턴으로 관리한다.
 * - 멀티 스레딩을 지원한다.
 * 
 * 컨트롤러 (프레젠테이션 계층)
 * - HTTP 요청을 받아 비즈니스 계층으로 전송
 * - 컨트롤러: 프레젠테이션 계층을 실제 구현한것
 * 
 * 서비스 (비즈니스 계층)
 * - 비즈니스 로직을 처리
 * 
 * 리포지토리(퍼시스턴스 계층)
 * - DB에 관한 로직 처리
 * 
 * DB로 가서 매핑해서 결과값을 리턴해주는 역할
 * 
 * DTO는 데이터를 전송할 때 사용한다.
 * 	웹 사이트에서 서버로 전송! 서버에서 웹으로 데이터를 전송할 때 사용!
 * Entity는 DB와 자바 객체를 매핑해서 CRUD 작업을 수행하므로 DTO와 사용 의미가 다르다.
 * 
 * sql 쿼리를 실행하면 insert문 값들이 어떻게 들어가는지 상세(세부사항) 기록해서 보는 명령문
 * 단점: 로그 파일이 매우 커질 수 있다.
 * logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
 * 
 * h2 DB의 url을 고정해서 하나의 DB에 접근할 수 있도록 설정
 * 기본값 true → 데이터 이름을 무작위 문자열로 DB 이름을 생성한다.
 * spring.datasource.generate-unique-name=false
 */
