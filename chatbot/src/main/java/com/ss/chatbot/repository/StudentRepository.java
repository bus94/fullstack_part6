package com.ss.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.chatbot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
