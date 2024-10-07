package com.ss.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ss.mybatis.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private ArticleService service;
	
	@GetMapping("/index.do")
	public String index(Model model) {
		log.info("index() 실행");
		
		model.addAttribute("list", service.index());
		
		return "index";
	}
	
	@GetMapping("/articles")
	public String articles(Model model) {
		log.info("articles() 실행");
		
		model.addAttribute("articleList", service.index());
		
		return "articles/show";
	}
	
	@GetMapping("/articles/{id}")
	public String showId(@PathVariable Long id, Model model) {
		log.info("showId() 실행");
		
		model.addAttribute("article", service.findById(id));
		
		return "articles/showid";
	}

}

/*
 * 잔디 이미지처럼 css,푸터,헤더로 나눠서 파일
 * include 하는걸로 페이지 추가하기 
 * 
 * index.do 를 호출하면 전체 게시글을 출력
 * 게시글을 클릭하면 상세페이지로 가는데
 * 디자인 두번째 이미지처럼 나와야된다.
 * 
 * 댓글을 저장하는 클래스,매퍼 만들어서 
 * 댓글저장 버튼을 클릭하면 댓글이 저장되서
 * 상세페이지에서 출력될 수 있도록! 
 * 
 * 실습! ajax()이용해서 데이터 정상적으로
 * 출력되는지 실습하기
 * 
 */