package com.ss.junit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.junit.entity.Member;

import lombok.NonNull;

public interface MemberRepository extends JpaRepository<Member, Long>{

	// 이름을 매개변수로 넘겨받아서 데이터가 있으면 멤버 객체를 반환 데이터가 없으면 null
	List<Member> findByName(String name);

	Member findByEmail(String email);
}
