package com.ss.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.backend.entity.Member;
import com.ss.backend.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional
	public Member register(Member member) {
		System.out.println("회원가입: " + member);
		
		// 비밀번호 암호화해서 넘기지 않으면 계속 로그인 실패!
		member.setPassword(encoder.encode(member.getPassword()));
		System.out.println("암호화: " + member.getPassword());
		
		return repo.save(member);
	}
	
}
