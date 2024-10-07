package com.ss.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AopMainController {
	// 메인 페이지 실행
	@GetMapping("/aop")
	public String aopMain() {
		log.info("메인 페이지 aopMain() 실행");
		
		// 조회, 출금, 입금 핵심 기능 할 때마다 위의 로그값처럼 실행
		
		return "aop";
	}

	// 두 번째 페이지 실행
	@GetMapping("/aop2")
	public String aop2() {
		log.info("두 번째 페이지 aop2() 실행");
		return "aop";
	}
	
	// 동시에 실행할 수 있는 around()
	@GetMapping("/aopAround")
	public String aopAround() {
		// 핵심 기능!
		log.info("board 게시글 조회");
		return "aop";
	}
}

/*
 * AOP(Aspect Oriented Programming) : 관점 지향 프로그래밍 
 * - OOP(객체 지향 프로그래밍)를 사용할 때 로깅, 트랜잭션, 보안 등과 같은 코드를 별도로 분리해서 하나의 단위로 모듈화의 개념으로 생각한다.
 * 
 * AOP에서 관점 2가지 → 핵심 관점, 부가적인 관점 ex) 프로그램을 제작 (은행 프로그램) 
 * 기본 핵심 기능: 계좌 이체, 잔액 조회, 입출금 등
 * (종단 관심사) 
 * 시스템에서 주요 로직에 해당하는 코드들
 * 
 * 부가적인 기능: 비밀번호 맞는지, 비밀번호 제대로 입력했는지, 값이 잘 들어왔는지 확인하는 로그값, 
 * 			  비밀번호가 맞지 않았을 때 현재 모든 작업을 초기화하는 트랜잭션 동작 등등 
 * (횡단 관심사 - 공통 기능)
 * → 기본 핵심 기능을 하게 되었을 때 중간 중간마다 부가적인 기능이 들어가게 된다. 이러한 공통된 기능들을 묶어서 사용한다.
 * 
 * 코드의 중복을 줄이고, 유지보수성을 높이기 위함
 * 
 * AOP를 실행하는 순서
 * 1.spring boot 실행 시 빈 생성 (AspectDemo)
 * 2.spring boot에서 aop 설정 확인 후 빈에 적용
 * 3. 실행의 흐름을 가로채는 프록시 자동으로 생성!
 * 
 */