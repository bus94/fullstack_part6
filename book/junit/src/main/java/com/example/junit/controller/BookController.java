package com.example.junit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.junit.entity.Book;
import com.example.junit.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookController {

	private final BookService bookService;
	
	// get , post (/book)
	// get  요청시 반환되는 문자열 get!
	// post 요청시 반환되는 문자열 post!
	// POST 요청 - 책 생성
    
	@PostMapping("/book")
	public ResponseEntity<?> saveBook(
			@RequestBody Book book
			){
		return new ResponseEntity<Book>(
				bookService.저장하기(book),
				HttpStatus.CREATED);
	}
	@GetMapping("/book")
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(
				bookService.findAll(),
				HttpStatus.OK
				);
	}
	 
	
	
	// get findbyId 한건조회
	//   반환되는 문자열 get id;
	
	// put 수정하기
	// delete 삭제하기 
	
	
	
}
