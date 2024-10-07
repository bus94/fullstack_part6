package com.ss.restful.dto;

import com.ss.restful.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
	private Long id;
	private String title;
	private String content;
	
	// DTO에서 DB랑 매핑을 할 수 있도록 Entity로 변환하는 메서드가 필요하다
	public Article toEntity() {
		// 객체를 초기화해서 수정할 수 있도록 엔티티 객체를 생성한다.
		return new Article(id, title, content);
	}
}
