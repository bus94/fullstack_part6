package com.ss.thymybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {
	@Autowired
	private ArticleService service;
	
	// 글쓰기
	@GetMapping("/new")
	public String newPage(Model model) {
		log.info("새글 작성! new() 실행");
		
		// 빈 Article 객체를 모델에 추가하여 폼에 바인딩(연결)
		model.addAttribute("article", new Article());
		
		return "article/new";
	}
	
	// 수정하기
	@PostMapping("/update")
	public String update(Article article) {
		log.info("update() 실행");
		log.info("article: " + article);
		
		// 결과 값이 제대로 저장되면 상세페이지 요청 안되면 error 페이지 생성해서 msg 출력
		service.update(article);
		
		// 뷰페이지로 이동
		// 새로 변경된 데이터를 요청
		return "redirect:/articles/" + article.getId();
	}
	
	// 댓글 추가하기
	@PostMapping("/commentNew")
	public String newComment(Comment comment) {
		log.info("commentNew() 실행");
		log.info("comment: " + comment);
		
		service.insertComment(comment);
		
		return "redirect:/articles/" + comment.getArticleId();
	}
	
	// 댓글 삭제하기
	@DeleteMapping("/comment/delete/{id}")
	public String deleteComment(@PathVariable int id) {
		// RestController, Controller 댓글 삭제 시
		// 1. 컨트롤러로 요청 받음 (id값 가져오기)
		// 2. 서비스 deleteComment(); 호출
		// 3. 서비스에서 mapper로 호출
		// 4. sql 문장 호출해서 실행
		// 5. 위의 내용들을 거꾸로 실행되면서 컨트롤러로 옴
		service.commentDelete(id);
		return "redirect:/articles";
	}
}
