package com.ss.article.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * JPA
 * - 객체 관계 매핑 기술의 표준으로 인터페이스 모음
 * - java 애플리케이션과 JDBC 사이에서 동작한다.
 * - 자바에서 sql을 DB로 전달하고 결과를 반환 받을 때 사용한다.
 * 
 * JPA 자동으로 테이블도 생성하고 sql을 보낼 때 어노테이션 필요
 * @Entity 붙은 클래스를 JPA가 각 필드의 어느테이션을 보고 DB 테이블과 매핑해 관리해준다.
 * 
 * spring.jpa.defer-datasource-initialization=true
 * sql파일에 있는 모든 내용들이 초기화를 실행한다.
 * 테이블 생성, 추가 코드, 삭제 코드 초기 데이터가 순서대로 저장될 수 있도록 해준다.
 * 
 */

@Entity // 현재 클래스는 Entity로 사용되는 클래스다
		// 조건: Entity로 사용할 클래스에는 기본 생성자는 무조건 설정해야한다. (설정하지 않으면 에러 발생)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	// 기본키랑 필드(컬럼)
	@Id // 필드를 생성하고 기본키로 설정한다.
	// @GeneratedValue // 기본키 값을 자동으로 생성한다. 시퀀스가 무조건 1부터 시작한다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스가 입력된 데이터 개수 다음부터 시작한다.
	private Long id;
	@Column // 필드를 테이블 컬럼명과 매핑한다.
	private String title;
	@Column
	private String content;
}
