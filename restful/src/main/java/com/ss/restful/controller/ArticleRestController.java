package com.ss.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.restful.entity.Article;
import com.ss.restful.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

// @RestController
//  어노테이션은 RestAPI용 컨트롤러로 사용된다.
//  뷰 페이지로 이동하는 것이 아닌 JSON 형식의 데이터를 반환한다.
@RestController
@Slf4j // 롬복에서 제공하는 로그
public class ArticleRestController {
	@Autowired
	private ArticleService service;
	
	// 전체 게시글을 보여달라는 요청이 들어왔을 때 동작
	@GetMapping("/api/articles")
	public List<Article> index() {
		log.info("RestController index() 실행");
		return service.index();
	}
}
