package com.ss.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.board.entity.Board;

@Repository
public interface Board_Repository extends JpaRepository<Board, Long>{
	// 페이징 처리를 하고 page 인터페이스로 넘어올 수 있도록 JPA 메서드를 생성
	// Page 페이징된 결과를 담고, 데이터를 여러 페이지로 나누어 반환할 때 사용된다.
	// 전체 데이터 수, 현재 페이지 번호, 총 페이지 수 정보를 포함하면서 Board 객체의 리스트 타입으로 데이터를 넘겨준다.
	
	// Pageable 전달되는 매개변수로 페이징에 필요한 정보를 넘겨줘야된다. 페이지 번호, 페이지 크기, 정렬 방식
	// 전체 페이지(1, 2, 페이지...)를 반환
	Page<Board> findAll(Pageable pageable);
	
	// 제목(title) 특정 키워드를 이용해서 데이터를 검색하는 쿼리를 생성한다.
	// Containing: Like 연산을 이용해서 특정 문자열이 포함된 데이터를 검색한다.
	Page<Board> findByTitleContaining(String keyword, Pageable pageable);
	
	// 내용(content)으로 검색
	Page<Board> findByContentContaining(String keyword, Pageable pageable);
	
	// 제목 또는 내용으로 검색
	Page<Board> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword, Pageable pageable);
}
