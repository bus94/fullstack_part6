package com.ss.board.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.board.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	// 회원 가입 시
	Users findByUsername(String username);
	
	// 로그인 시
	Users findByUsernameAndPassword(String username, String password);
}
