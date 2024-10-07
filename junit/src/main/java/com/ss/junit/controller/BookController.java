package com.ss.junit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.junit.entity.Book;
import com.ss.junit.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookController {
	private final BookService bookService;

	// get, post (/book)
	// get 요청 시 반환되는 문자열 get!
	// post 요청 시 반환되는 문자열 post!
	@PostMapping("/book")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.저장하기(book), HttpStatus.CREATED);
	}

	@GetMapping("/book")
	public ResponseEntity<?> findAll() {
							// 버전에 따라 타입을 설정 필요 유무가 달라진다.
							// 와일드 카드는 설정할 필요가 없다.
		return new ResponseEntity<>(bookService.모두가져오기(), HttpStatus.OK);
	}
	
	// get findById 한 건 조회
	// 반환되는 문자열 get id;
	@GetMapping("/book")
	public ResponseEntity<?> findById(@RequestBody Long id) {
		return new ResponseEntity<>(bookService.아이디로검색(id), HttpStatus.OK);
	}

	// put 수정하기
	// delete 삭제하기
}
