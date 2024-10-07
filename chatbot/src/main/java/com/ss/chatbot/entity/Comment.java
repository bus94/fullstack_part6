package com.ss.chatbot.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 댓글 번호
	@Column
	private String nickname; // 닉네임
	@Column
	private String body; // 내용
	
	// 댓글이 속한 게시글과 관계
	// 다대일
	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;
	
//	// 댓글이 연결된 Post와 연결을 하는 컬럼을 설정
//	@ManyToOne
//	@JoinColumn(name="post_id")
//	private Post post; // 댓글이 속한 게시글
	
//	// 하나의 사용자가 여러 개의 댓글을 작성할 수 있다.
//	@ManyToOne
//	private Customer customer;
}
