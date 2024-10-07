package com.ss.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.restful.entity.Article;
import com.ss.restful.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // springboot가 실행할 때 클래스 인식해서 (자동) 객체 생성해서 등록! 
public class ArticleService {
	// DB 랑 연결해서 저장, 조회할 수 있도록 repository 객체 생성
	@Autowired
	private ArticleRepository repository;

	public List<Article> index() {
		log.info("service index()");
		return repository.findAll();
	}
}