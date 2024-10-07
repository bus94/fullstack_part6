package com.ss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.backend.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	// 이메일로 로그인시 실행!
	Member findByEmail(String email);

}