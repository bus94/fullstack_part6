package com.example.junit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.junit.entity.Book;
import com.example.junit.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

	// 생성자를 이용해서 주입받는 방법

//	@Autowired
//	public BookService(BookRepository book) {
//		this.bookRepo = book;
//	}	
	private final BookRepository bookRepo;

	@Transactional
	public Book 저장하기(Book book) {

		return bookRepo.save(book);
	}

	
	// 한건가져오기(Long id)

	// 모두가져오기()
	// readOnly 실제 읽기만 할 때는 
	// 특별히 어떤 작업이 읽어나지 않는다.
	// 데이터 변경,수정,삭제 롤백이나
	// 커밋 작업이 필요없다!
	@Transactional(readOnly = true)
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	// 수정하기()

	// 삭제하기()

}
