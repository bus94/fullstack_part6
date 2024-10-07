package com.ss.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.board.entity.Board;
import com.ss.board.entity.Users;
import com.ss.board.repository.UserRepository;
import com.ss.board.service.BoardService;
import com.ss.board.service.NaverApiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FrontController {
	@Autowired
	private BoardService boardService;
	
//	@Autowired
//	private NaverApiService naver;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository repo;
	
	// 회원가입
	@GetMapping("/join")
	public String join() {
		return "login/join";
	}
	
	// 회원가입 시 처리 끝나면 index1로 이동
	@PostMapping("/joinPro")
	public String joinPro(Users user) {
		String inputPw = user.getPassword();
		String encPw = encoder.encode(inputPw);
		
		user.setPassword(encPw);
		user.setRole("ROLE_USER");
		repo.save(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/restIndex")
	public String restIndex(Model model) {
		return "board/restIndex";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@PostMapping("/login/loginPro")
	public String loginPro() {
		return "board/index1";
	}
	
	// 모든 url을 받아서 뷰페이지로 보내주는 역할
	@GetMapping("/index1")
	public String indexPage(Model model, @RequestParam(defaultValue = "0") int page) {
		// 로깅을 찍을 때 AOP
		log.info("indexPage() 실행");
		
		Page<Board> boardList = boardService.index(page);
		
		// 게시글에 대한 내용만 출력
		model.addAttribute("boardList", boardList.getContent());
		// 페이지처리를 할 수 있도록!
		model.addAttribute("page", boardList);
		log.info(""+boardList);
//		// 네이버 서비스 실행!
//		model.addAttribute("summary", naver.getSummary());
		// naver.craw();
		
		return "board/index1";
	}
}
