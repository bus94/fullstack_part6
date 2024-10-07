package com.ss.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter 	// Getter만 구현!
@ToString 	// toString만 구현!
@NoArgsConstructor
@AllArgsConstructor
// 어노테이션이 붙은 클래스 이름으로 springboot 자동으로 테이블을 생성
public class Article {
	@Id				// oracle 사용 시 GenerationType.SEQUENCE
	@GeneratedValue(strategy = GenerationType.IDENTITY) // → mysql에서 사용
	private Long id;
	@Column
	private String title;
	@Column
	private String content;
}
