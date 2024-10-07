package com.ss.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.junit.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	boolean existsById(Long id);
}
