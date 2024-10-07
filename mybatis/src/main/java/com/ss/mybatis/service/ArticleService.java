package com.ss.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.mybatis.dto.Article;
import com.ss.mybatis.mapper.ArticleMapper;

@Service
public class ArticleService {
	@Autowired
	private ArticleMapper mapper;
	
	// 모든 게시글을 반환하는 메서드
	public List<Article> index() {
		// 1. Mapper 호출
		// 2. 결과 반환
		return mapper.findArticles();
	}

	public Article findById(Long id) {
		return mapper.findById(id);
	}
}
