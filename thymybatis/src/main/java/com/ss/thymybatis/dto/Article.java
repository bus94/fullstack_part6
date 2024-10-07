package com.ss.thymybatis.dto;

import com.ss.thymybatis.dto.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	// ID가 null로 들어가면 안되므로 id를 추가하면 된다.
	private int id;

	private String title;
	private String content;
}

/*
CREATE TABLE article (
    id bigint AUTO_INCREMENT PRIMARY KEY,  -- 고유 ID, 자동 증가
    title VARCHAR(255) NOT NULL,        -- 제목, NULL 허용 안됨
    content VARCHAR(500) NOT NULL,      -- 내용, 500자까지 허용, NULL 허용 안됨
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 생성 시간, 기본값 현재 시간
);
*/