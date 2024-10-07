package com.ss.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ss.article.dto.ArticleDTO;
import com.ss.article.entity.Article;
import com.ss.article.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {
	
	// JPA repository 인터페이스 객체를 선언하고 빈을 스프링 컨테이너로부터 주입 받아서 사용한다.
	// (빈: 스프링 컨테이너가 관리하는 객체)
	// Ioc - 객체를 직접 관리하는 것이 아니라 외부에서 관리한다.
	// springboot가 미리 생성해놓은 객체를 가져다가 자동으로 연결한다.
	@Autowired
	private ArticleRepository articleSql;
	
	// 추가할 게시글을 보여주는 페이지 호출
	@GetMapping("/articles/new")
	public String newArticle() {
		
		// 페이지 이동
		return "articles/new";
	}
	
	@PostMapping("/articles/create")
	public String createArticle(ArticleDTO dto) {
		// 롬복에서 제공하는 @Slf4j 어노테이션은 반드시 문자열만 가능하다.
		log.info("정보를 출력하는 로그");
		log.info("dto: " + dto.toString());
		System.out.println("dto: " + dto);
		// dto.setId(1L); // 1을 long 타입으로 작성 => 1L
		// DTO의 데이터를 entity 타입으로 변환해서 sql로 호출돼서 실행할 수 있도록 한다.
		Article article = dto.toEntity();
		log.info(article.toString());
		
		// 리포지토리한테 데이터베이스에 저장해달라는 메서드 호출하기
		// save()
		Article result = articleSql.save(article);
		log.info("결과값: " + result);
		
		// 추가된 내용을 기준으로 전체 조회를 해서 게시글 페이지로 갈 수 있도록 요청
		return "redirect:/articles";
	}
	
	@GetMapping("/articles")
	public String index(Model model) {
		log.info("컨트롤러의 index() 실행");
		
		// 테이블에 저장된 모든 글을 얻어온다.
		List<Article> list = articleSql.findAll();
		log.info(list + "");

		// 가져온 글을 show.mustache로 전송
		model.addAttribute("articleList", list);
		
		return "articles/show";
	}
	
	// 단 건 (상세)조회 요청
	@GetMapping("/articles/{id}")
	public String show(@PathVariable Long id, Model model) {
		log.info("한 건 조회 메서드 실행");
		log.info("id: " + id);
		
		// 만약 id 값으로 데이터를 찾으면 객체로 넘겨주면 되는데, 데이터를 찾지 못하면 어떤 값을 넘겨야할지 설정이 안되어있다.
		// 따라서 데이터가 없다면 orElse() 메서드를 이용해서 null 리턴시킨다
		Article art = articleSql.findById(id).orElse(null);
		model.addAttribute("article", art);
		
		return "articles/showid";
	}
	
	// 수정 두 가지 화면이 필요하다
	// 1. 수정할 페이지 (입력)
	// 2. 수정하기 버튼을 클릭 시 완료된 화면 현재 페이지(단 건 조회), 전체 조회
	@GetMapping("/articles/{id}/update")
	public String update(@PathVariable Long id, Model model) {
		log.info("한 건 수정 메서드 실행");
		log.info("id: " + id);
		
		Article art = articleSql.findById(id).orElse(null);
		model.addAttribute("article", art);
		
		return "articles/update";
	}
	
	@PostMapping("/articles/{id}/edit")
	public String edit(@PathVariable Long id, String title, String content, Model model) {
		log.info("한 건 수정 완료 메서드 실행");
		log.info("id: " + id);
		log.info("title: " + title);
		log.info("content: " + content);
		
		Article art = articleSql.findById(id).orElse(null);
		art.setTitle(title);
		art.setContent(content);
		articleSql.save(art);
		
		return "redirect:/articles/" + id;
	}
	
	@GetMapping("/articles/{id}/delete")
	public String edit(@PathVariable Long id, Model model) {
		log.info("한 건 삭제 메서드 실행");
		log.info("id: " + id);
		
		Article art = articleSql.findById(id).orElse(null);
		articleSql.delete(art);
		
		return "redirect:/articles";
	}

}

/*
 * H2 Database
 * - 테스트 단계에서 사용하거나 작은 규모의 프로젝트에서 사용된다.
 * - DB 데이터를 모두 메모리에 올려서 관리
 * - 메모리가 종료되면 모든 데디터가 삭제된다.
 * - spring data jpa 라이브러리를 추가 콘솔창에 url을 이용한다.
 * - url: localhost:포트번호/h2-console
 * 
 * 스프링(spring)
 * - 자바 기반으로 애플리케이션
 * - 대규모 서비스(엔터프라이즈)
 *
 * 스프링부트(spring boot)
 * - 스프링의 복잡한 설정을 쉽게 만들어 준 것
 * - 빠르게 스프링 프로젝트를 설정
 * 
 * 차이점
 * - 스프링은 개발에 필요한 환경을 수동으로 구성
 * - 스프링 부트는 자동 구성
 * - 내장 was의 유무
 * 	 스프링 부트는 처음 부터 was 가지고 있다.
 * 	 기본적으로 톰캣
 * - was : 웹 애플리케이션을 실행하기 위한 장치, 동적 사이트를 작성할 때 사용하는 서버
 * 
 */
