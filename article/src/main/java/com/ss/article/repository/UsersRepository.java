package com.ss.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.article.entity.User;

public interface UsersRepository extends JpaRepository<User, Long>{
	
}
