package com.ss.junit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.junit.entity.Member;
import com.ss.junit.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private PasswordEncoder pass;
	
	@Autowired
	private MemberRepository memberRepo;
	
	public Member 저장하기(Member member) {
		return memberRepo.save(member);
	}

	@Transactional(readOnly = true)
	public List<Member> 가져오기() {
		return memberRepo.findAll();
	}
	
	// 로그인 시 암호화된 비밀번호 확인
	public Member login(Member loginData) {
//		Member db = memberRepo.findByEmail(loginData.getEmail()).orElse(null);
		Member db = memberRepo.findByEmail(loginData.getEmail());
		// 비밀번호 비교
		if(pass.matches(loginData.getPassword(), db.getPassword())) {
			return db;
		}
		return null;
	}
}
