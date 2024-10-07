package com.ss.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.restful.entity.Member;
import com.ss.restful.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	@Autowired
	private MemberRepository memberSql;
	
	// 아이디로 조회
	public Member getMemberById(String id) {
		return memberSql.findById(id);
	}

	// 이메일로 조회
	public Member getMemberByEmail(String email) {
		return memberSql.findByEmail(email);
	}

	// 성별로 조회
	public List<Member> getMemberByGender(String gender) {
		return memberSql.findByGender(gender);
	}

	// 취미로 조회
	public List<Member> getMemberByHobby(String hobby) {
		return memberSql.findByHobbyContaining(hobby);
	}

	// 나이로 조회
	public List<Member> getMemberByAgeGreater(Integer age) {
		return memberSql.findByAgeGreaterThanEqual(age);
	}

	// 전체 나이 조회
	public List<Member> getMemberByAge() {
		return memberSql.findByAge();
	}
}
