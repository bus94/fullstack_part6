package com.ss.chatbot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 게시글 번호
	
	@Column // 필드를 테이블 컬럼과 매핑한다.
	private String title;
	private String content;
	
	// 하나의 게시글에서 여러 개의 댓글을 조회할 수 있다.
	// 일대다
	// 게시글에 달린 댓글 리스트를 만든다.
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Comment> comment;
}
