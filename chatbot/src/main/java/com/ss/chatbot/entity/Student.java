package com.ss.chatbot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

// 학생이라는 테이블을 생성할 수 있도록 JPA 알려줘야된다.
@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 학생 각각 학번 등의 구별하는 식별자
	private String name; // 학생 이름
	
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	
//	// 테이블 조인
//	// 학생 테이블에서 외래키로 school_id가 추가된다.
//	// school_id 컬럼명에 School 대표값(기본키)을 저장한다.
//	@JoinColumn(name="school_id") // @JoinColumn으로 학생 테이블과 학교 테이블을 조인하는 외래키를 설정한다.
//	private School school; // 학생이 속한 학교
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="passport_id")
//	private Passport passport;
}
