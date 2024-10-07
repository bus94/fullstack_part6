package com.ss.junit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.junit.entity.Book;
import com.ss.junit.service.BookService;

import lombok.RequiredArgsConstructor;

// security를 추가하게되면 CrossOrigin의 역할이 무의미하다. 왜냐하면 security를 먼저 거쳐가기 때문.
//@CrossOrigin // 하위 자바스크립트 모든 요청을 받는다. (현재 기준으로는 BookController 외부에서 오는 모든 요청을 받는다.)
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

	// CORS 외부에서 자바스크립트 요청이 오는 걸 막는다.
	// 자바스크립트의 요청을 풀어주는 어노테이션
//	@CrossOrigin
	@GetMapping("/book")
	public ResponseEntity<?> findAll() {
							// 버전에 따라 타입을 설정 필요 유무가 달라진다.
							// 와일드 카드는 설정할 필요가 없다.
		return new ResponseEntity<>(bookService.모두가져오기(), HttpStatus.OK);
	}
	
	// get findById 한 건 조회
	// 반환되는 문자열 get id;
	@GetMapping("/book/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return new ResponseEntity<>(bookService.아이디로검색(id), HttpStatus.OK);
	}

	// put 수정하기
	@PutMapping("/book/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
		Book book = bookService.updateBook(id, updateBook);
		if (book != null) {
			return ResponseEntity.ok(book);
		} else {							// body는 없기 때문에 build() 기입
			return ResponseEntity.notFound().build();
		}
	}
	
	// delete 삭제하기
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		boolean result = bookService.deleteBook(id);
		
		// 삭제가 정상적으로 되었을 경우
		if(result) {
			// 204
			return ResponseEntity.noContent().build();
		} else {
			// 404 Not Found
			return ResponseEntity.notFound().build();
		}
	}
	
}
