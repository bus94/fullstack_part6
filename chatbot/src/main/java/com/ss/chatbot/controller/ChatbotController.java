package com.ss.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.chatbot.entity.Article;
import com.ss.chatbot.entity.Comment;
import com.ss.chatbot.repository.ArticleRepository;
import com.ss.chatbot.repository.CommentRpository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatbotController {
	
	@Autowired
	private ArticleRepository article;
	@Autowired
	private CommentRpository comment;
	
	@GetMapping("/index.do")
	public String index() {
		return "index";
	}
	
	@GetMapping("/articles")
	public String list(Model model, @RequestParam(defaultValue = "0") int page) { // defaultValue = "" 처음 페이지가 실행되면 null이기 때문에 초기값을 미리 설정해두는 것!
		// 페이지당 5개의 게시글, 댓글을 보여줌
		// 페이지 번호와 페이지 크기를 받아서 페이지당 5개의 게시글을 출력할 수 있도록 설정한다.
		
		// Pageable sprint Data JPA에서 DB에서 페이지 요청을 정의하는 객체
		// PageRequest JPA가 데이터를 페이징 처리할 수 있도록 도와주는 객체 인터페이스로 반환된다.
		
		// 페이징 처리 객체 생성해서 인터페이스로 반환하기 전에 특정 페이지의 데이터를 가져오되 5개의 항목씩 가져오라는 요청!
		Pageable pageable = PageRequest.of(page, 5);
		// 정렬 옵션을 추가할 수 있다.
		// of(page, 5, Sort.by(정렬 기준되는 컬럼명).ascending()): 오름차순
		// of(page, 5, Sort.by(정렬 기준되는 컬럼명).descending()): 내림차순
		Page<Article> articlePage = article.findAll(pageable);
		log.info("데이터: " + articlePage);
		
		model.addAttribute("articlePage", articlePage);
		
		return "show";
	}	
	
	@GetMapping("/articles2")
	public String list2(Model model, @RequestParam(defaultValue = "0") int commentPage) {
		Pageable pageable = PageRequest.of(commentPage, 5);
		Page<Comment> commentList = comment.findAll(pageable);
		// 게시글 번호를 가지고 와서 1번 게시글의 댓글만 페이징 처리
		List<Comment> commentList2 = comment.findByArticleId(1L);
		log.info("데이터: " + commentList);
		log.info("직접 만든 쿼리로 가져온 데이터: " + commentList2);
		
		model.addAttribute("commentList", commentList);
		model.addAttribute("commentList2", commentList2);
		
		return "pageInfo";
	}	
}
