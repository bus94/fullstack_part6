package com.ss.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.restful.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	
}
