package com.ss.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.chatbot.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
