package com.ss.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.board.entity.Board;
import com.ss.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@RestController // 데이터를 반환
@RequestMapping("/board/rest")
@Slf4j
public class BoardRestController {
	@Autowired
	private BoardService boardService;
	
	// 기본 게시글 목록 페이지 (페이징 처리)
	@GetMapping("/list")
	public Page<Board> list( @RequestParam(defaultValue = "0") int page) {
		log.info("rest list() 실행중");
		Pageable pageable = PageRequest.of(page, 5);
		return boardService.getBoardList(pageable);
	}
	
	@PostMapping("/search")
	public Page<Board> search(String searchOption, String keyword, @RequestParam(defaultValue = "0") int page) {
		// 1. service 객체 생성
		// 2. 페이지정보를 저장하는 Pageable
		log.info("rest search() 실행중");
		Pageable pageable = PageRequest.of(page, 5);
		return boardService.searchBoards(searchOption, keyword, pageable);
	}
}
