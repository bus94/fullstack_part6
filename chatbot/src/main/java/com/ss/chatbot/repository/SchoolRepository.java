package com.ss.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.chatbot.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long>{
	
}
