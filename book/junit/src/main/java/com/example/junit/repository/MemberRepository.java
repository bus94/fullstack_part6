package com.example.junit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.junit.entity.Member;

public interface MemberRepository 
		extends JpaRepository<Member, Long>{

	// 이름을 매개변수로 넘겨받아서 
	// 데이터가 있으면 멤버 객체를 반환
	//  이름이 중복일 수도 있다.
	// 데이터가 없으면 null
	List<Member> 
		findByName(String name);
	
	
	
}
