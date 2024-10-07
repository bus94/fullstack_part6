package com.example.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.junit.entity.Book;

public interface BookRepository
   extends JpaRepository<Book, Long>{

}
