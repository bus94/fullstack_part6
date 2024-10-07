package com.ss.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.security.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	// 회원 가입 시
	Users findByUsername(String username);
	
	// 로그인 시
	Users findByUsernameAndPassword(String username, String password);
	
//	@Query(value="select * from user")
//	User find마음대로();
}
