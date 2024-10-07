package com.example.junit.repository;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
// 단위 테스트
//  - 메서드 단위로 테스트
import org.springframework.transaction.annotation.Transactional;

import com.example.junit.entity.Member;

import lombok.extern.slf4j.Slf4j;

// 통합 테스트
//  - 전체 테스트(controller,service,repository)
//  - api 테스트 단위나 애플리케이션 기능단위

@Slf4j
@SpringBootTest // springboot에 있는 내용을 가지고 테스트를 진행!
public class MemberRepositoryTest {

	
	// 1. Mycontroller와 똑같이 http
	//   요청이 잘 가는지 BookController
	//   테스트하기 
	// 2. BDD 패턴 한번 정보를 찾아보기
	
	
	// 실제 MemberRepository
	@Autowired
	private MemberRepository resp;

	// Junit의 테스트 메서드가 여러개 일 수 있다
	// 그럴때 특정메서드를 생성해서 그 안에 테스트할
	// 내용을 작성한다.
	// 실행 ctrl + f11 (전부 실행)
	// 메서드명 위에 커서를 두고 ctrl + f11누르면
	// 커서가 올라간 메서드만 실행!

	// Junit
	// - 자바언어에서 사용하는 테스트
	// 프레임워크
	// - 프로그램 코드가 제대로 작동하는
	// 지 확인하는 실행하는 도구
	// - 스프링부트 2.2.0 이전 Junit4 기본적용됨
	// - 2.2.0 이후 버전 기본적으로 Junit5 기본적용됨
	// - Junit5는 런타임시 Java8 이상
	// - spring-web 라이브러리에 추가됨

	@Test // 테스트를 진행하는 메서드!
	@Transactional
	void crud_test1() {
		// 저장된 데이터의 개수를 얻어오기

//		long count = resp.count();
//		log.info("총 개수:"+ count);

		// 지정된 아이디에 해당되는 데이터가
		// 존재하는지 여부 (boolean)
//		boolean exists = resp
//					.existsById(1L);
//		log.info("존재 여부확인:{}",exists);

	}

	@Test
	@Transactional // 여러 작업을 하나의 트랜잭션으로 묶어서 실행
					// 테스트 중에 데이터베이스에 추가되거나
					// 삭제혹은 변경된 데이터가 실제로 반영되지
					// 않도록 테스트 전 상태로 돌리기!
	void select_test() {

		// 한번에 여러개를 삭제하는
		// 명령문 확인
		// List.of() 이거보다 간단하고
		// 명확하게 Guava라이브러리에서
		// 제공하는 메서드를 이용한다.

		// 1. Arraylist타입으로 객체생성
		// 2. 해당 엔티티들을 조회한다.
		// 3. List타입으로 반환되서
		// 4. deleteAll()메서드로
		// 전달되서 삭제된다.

//		resp.deleteAll(
//			resp.findAllById(
//				Lists.newArrayList(1L,3L,5L)
//				)	
//			);
//		

		// 전체 멤버 목록 조회
//		List<Member> members
//			= resp.findAll();
//		
		// 람다식으로 리스트나 컬렉션 있는
		// 데이터들을 하나씩 출력하는 방식
//		members
//		.forEach(System.out::println);
//		
		// 테스트
		// 단일 데이터 삭제하기 Id
		resp.deleteById(1L);
		List<Member> members = resp.findAll();

		members.forEach(System.out::println);

		// 이름으로 조회했을 때
		// 정보 출력!
		List<Member> list = resp.findByName("IU");

		list.forEach(System.out::println);

	}

	@Test // 테스트를 진행하는 메서드!
	@Transactional
	void select_test2() {
		// 페이징 - Page인터페이스
		// PageRequest.of(얻어올 페이지번호,페이지의 크기)

		Page<Member> members = resp.findAll(PageRequest.of(1, 3));

		System.out.println(members);

		// 전체 데이터의 개수
		System.out.println(members.getTotalElements());
		// 현재 페이지의 데이터 개수
		System.out.println(members.getNumberOfElements());

		// 정렬 여부
		System.out.println(members.getSort());

		// PageRequest.of(얻어올 페이지번호,
		//                페이지의 크기,
		//                정렬방식)
		// Sort.by() 메서드 이용해서 
		//  정렬방식을 지정할 수있다.
		//  기본적으로 오름차순
		
		
		
		Page<Member> findName = resp
				.findAll(
				 PageRequest.of(1,
						 	    3,
						 	  Sort.by(
						 	  Order.by("id")
						 			 )));
		findName.forEach(System.out::println);
		
		// Order객체에서 정렬의 기준을
		// 변경해서 오름차순과 내림차순으로
		// 데이터를 가져오는지 확인
		// 만약 페이지가 없다면 어떤 내용이
		// 나오는지 테스트를 해보기!
	
	}
}
