package com.ss.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.ss.board.entity.Board;
//import com.ss.board.repository.Board_Repository;

import com.ss.board.entity.Board;
import com.ss.board.entity.Reply;
import com.ss.board.repository.Board_Repository;
import com.ss.board.repository.ReplyRepository;

@Controller
public class BoardController {
	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private Board_Repository boardRepository;

	@GetMapping("/board/index")
	public String index(Model model, @RequestParam(defaultValue = "0") int page) {

		// 페이지네이션을 위한 페이지 및 사이즈 설정
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page, pageSize);

		// 페이지로부터 게시글 목록 가져오기
		Page<Board> boardPage = boardRepository.findAll(pageable);

		// 모델에 게시글 목록 추가
		model.addAttribute("boardList", boardPage.getContent());
		model.addAttribute("page", boardPage);

		return "board/index";
	}

	@GetMapping("/board/detail/{no}")
	public String showDetail(@PathVariable("no") Long no, Model model) {
		Board board = boardRepository.findById(no)
				.orElseThrow(() -> new IllegalArgumentException("Invalid board id: " + no));

		model.addAttribute("board", board);

		// 게시글 번호와 작성자에 해당하는 댓글 가져오기
		List<Reply> replies = replyRepository.findByBoardNoAndWriterNo(no, board.getWriterNo());

		// 가져온 댓글을 모델에 추가
		model.addAttribute("replyList", replies);

		// log.info("{}", board);
		return "board2/detail";
	}

	@GetMapping("/board/view/{id}")
	public String viewBoard(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") int page, Model model) {
		// 게시글 정보 조회
		Board board = boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid board ID: " + id));

		// 댓글 페이징 처리 (페이지 당 5개)
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<Reply> replyPage = replyRepository.findByBoardNo(id, pageable);

		// 모델에 게시글과 댓글 정보 추가
		model.addAttribute("boardList", board);
		// model.addAttribute("replyList", replyPage.getContent());
		// model.addAttribute("replyPage", replyPage);

		return "board/index";
	}

	@PostMapping("/board/search")
	public String search(@RequestParam(value = "searchOption", required = false) String searchOption,
			@RequestParam("search") String keyword, Model model) {
		System.out.println("보드 컨트롤러 search() 실행 중");
		System.out.println("searchOption: " + searchOption);
		System.out.println("keyword: " + keyword);
		Page<Board> searchResultPage = null;
		Pageable pageable = PageRequest.of(0, 5); // 페이지네이션 설정

		if (searchOption != null && keyword != null) {
			switch (searchOption) {
			case "title":
				searchResultPage = boardRepository.findByTitleContaining(keyword, pageable);
				break;
			case "content":
				searchResultPage = boardRepository.findByContentContaining(keyword, pageable);
				break;
			case "titleContent":
				searchResultPage = boardRepository.findByTitleContainingOrContentContaining(keyword, keyword, pageable);
				break;
			default:
				// 기본값으로 전체 게시글 조회
				searchResultPage = boardRepository.findAll(pageable);
			}
		} else {
			// 검색어가 없는 경우 전체 게시글 조회
			searchResultPage = boardRepository.findAll(pageable);
		}

		model.addAttribute("boardList", searchResultPage.getContent());
		model.addAttribute("page", searchResultPage);
		model.addAttribute("loginMember", "admin");

		return "board/index1"; // 결과를 보여줄 뷰 이름
	}

//	@Autowired
//	private BoardRepository board;

//	@GetMapping("/index.do")
//	public String board(Model model, @RequestParam(defaultValue = "0") int page) {
//		Pageable pageable = PageRequest.of(page, 5);
//		Page<Board> boardList = board.findAll(pageable);
//		log.info("Board 리스트 데이터: " + boardList);
//		model.addAttribute("boardList", boardList);
//		return "board/index";
//	}
}
