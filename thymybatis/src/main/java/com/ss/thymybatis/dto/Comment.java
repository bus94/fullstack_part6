package com.ss.thymybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int id;			// 댓글 번호
	private String nickname;	// 닉네임
	private String body;		// 댓글 내용
	private int articleId;		// 댓글 대상 게시글 ID
}

/*
CREATE TABLE comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(255),
    body varchar(1000),
    articleId BIGINT,
    FOREIGN KEY (articleId) REFERENCES article(id) ON DELETE CASCADE
);
*/