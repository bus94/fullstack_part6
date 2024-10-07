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
	
	@Transactional
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
//	public Book findById() {
//		return bookRepo.findById().orElse(null);
		// 만약 데이터가 없으면 예외를 던지기
		// EntityNotFoundException(메시지)
		//return bookRepo.findById().orElseThrow(() -> new EntityNotFoundException("책을 찾을 수 없습니다"));
//	}
	@Transactional(readOnly = true)
	public Object 아이디로검색(Long id) {
		return bookRepo.findById(id);
	}

	// 수정하기()
	@Transactional
	public Book updateBook(Long id, Book updateBook) {
		Book book = bookRepo.findById(id).orElse(null);
		if (book != null) {
			// 데이터가 있기 때문에 수정하는 메서드 save()
			book.setTitle(updateBook.getTitle());
			book.setAuthor(updateBook.getAuthor());
			// 위에서 필요한 내용으로 수정하고, 수정된 객체를 save()로 보내면 기존 내용 있다면 update 처리!
			return bookRepo.save(book);
		} else {
			return null;
		}
	}
	
	// 삭제하기()
	@Transactional
	public boolean deleteBook(Long id) {
		// 책의 존재가 있는지 없는지 확인하는 메서드
		if (bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			return true;
		}
		// 책이 존재하지 않는다.
		return false;
	}
	
	public Object 수정하기(Long id, Book updateBook) {
		return null;
	}

	public Object 삭제하기(Long id) {
		return null;
	}

}
