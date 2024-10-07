package com.ss.chatbot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 학교를 구분하는 식별자
	@Column
	private String name; // 학교 이름
	
	// 여러 학생들이 속한 리스트
	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL) // ALL : 삽입, 수정, 삭제가 모두 적용
	private List<Student> students;
	
	// 서버 설정하는 파일에 들어가서
	// spring.jpa.hibernate.ddl-auto=update 를 입력
	// → JPA가 자동으로 테이블을 생성할 수 있도록 업데이트 속성을 지정하면 된다.
	// 	 기존 테이블은 그대로 두고, 새로운 또는 변경된 엔티티가 있다면 테이블을 업데이트 한다.
	
	// create 속성
	// - 애플리케이션이 실행할 때마다 기존 테이블을 삭제하고 새로운 테이블을 생성한다.
	// 	 단점: 기존 모든 데이터가 삭제된다. (개발하는 중에는 잘 사용하지 않는다.)
	
	// validate 속성
	// 테이블이 엔티티 클래스와 일치하는지 확인
	// 일치하지 않으면 오류가 발생, 새로운 테이블이나 필드를 생성하지 않는다.
}
