package com.ss.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.board.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
}
