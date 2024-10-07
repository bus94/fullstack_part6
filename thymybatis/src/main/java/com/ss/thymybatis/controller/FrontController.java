package com.ss.thymybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.BookDTO;
import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FrontController {
	// 뷰페이지로 이동하는 역할을 하는 컨트롤러

	@Autowired
	private ArticleService service;

	// 목록으로
	@GetMapping("/articles")
	public String indexPage(Model model) {
		log.info("게시글 보기! index() 실행");

		model.addAttribute("articleList", service.findAll());

		return "article/index";
	}

	// 글 번호를 이용해서 데이터를 상세페이지로 출력
	@GetMapping("/articles/{id}")
	public String show(@PathVariable int id, Model model) {
		log.info("show() 실행");
		log.info("articles id: " + id);

		Article article = service.findById(id);
		log.info("article: " + article);
		model.addAttribute("article", article);
		
		// 빈 객체를 넘기면 객체를 생성하고 글의 번호를 comment에 저장해서 보내주면 자동으로 ArticleId값 저장
		Comment com = new Comment();
		com.setArticleId(id);
		log.info("com: " + com);
		model.addAttribute("comment", com);
		
		List<Comment> commentList = service.commentList(id);
		log.info("commentList: " + commentList);
		model.addAttribute("commentList", commentList);

		return "article/show";
	}

	// 수정하기 뷰페이지
	@GetMapping("/articles/{id}/update")
	public String update(@PathVariable int id, Model model) {
		log.info("수정창 보기! update() 실행");
		log.info("id: " + id);

		Article article = service.findById(id);

		log.info("article : " + article);
		model.addAttribute("article", article);

		// 바인딩을 할 때는 한 필드에 하나씩만 연결을 해야된다.
		// th:field 속성을 저장했을 때 컨트롤러에서 article값을 저장해서 보내주면 자동으로 value값에 저장해준다.
		return "article/update";
	}

//	@GetMapping("/comment")
//	public String comment(Model model) {
//		log.info("댓글창 보기! comment() 실행");
//		model.addAttribute("comment", new Comment());
//		return "comment/comments";
//	}

	@GetMapping("/form1")
	public String formPage() {
		return "post/form1";
	}

	@GetMapping("/form2")
	public String formPage2(Model model) {
		model.addAttribute("bookDTO", new BookDTO());
		return "post/form2";
	}
}
