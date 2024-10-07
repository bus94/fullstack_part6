package com.ss.junit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.junit.entity.Book;
import com.ss.junit.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {
	// final은 선언과 동시에 초기화가 되므로, 객체 생성을 무조건 해야한다.
	// 생성자를 이용해서 주입받는 방법
	// 1. BookService라는 생성자 만들 때 BookRepository 설정
	// 2. @RequiredArgsConstructor 어노테이션 사용해서 생성자 만들기
	
//	@Autowired
//	public BookService(BookRepository book) {
//		this.bookRepo = book;
//	}

	private final BookRepository bookRepo;
	
	public Book 저장하기(Book book) {
		return bookRepo.save(book);
	}

	// 모두 가져오기()
	// readOnly 실제 읽기만 할 때는 특별히 어떤 작업이 일어나지 않는다. 데이터 변경, 수정, 삭제 롤백이나 커밋 작업이 필요없다.
	@Transactional(readOnly = true)
	public List<Book> 모두가져오기() {
		return bookRepo.findAll();
	}

	// 한 건 가져오기(Long id)
	@Transactional(readOnly = true)
	public Book 아이디로검색(Long id) {
		return null;
	}

	public Object 수정하기(Long id, Book updateBook) {
		return null;
	}

	public Object 삭제하기(Long id) {
		return null;
	}
	
	// 수정하기()
	
	// 삭제하기()
}
