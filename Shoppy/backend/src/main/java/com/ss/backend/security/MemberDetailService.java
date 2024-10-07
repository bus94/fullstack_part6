package com.ss.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss.backend.entity.Member;
import com.ss.backend.repository.MemberRepository;

@Service
public class MemberDetailService implements UserDetailsService{

	@Autowired
	private MemberRepository resp;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("loadUser: " + email);
		Member member = resp.findByEmail(email);
		
		// 실행한 결과
		System.out.println("실행한 결과: " + email);
		
		if(member != null) {
			return new MemberDetails(member);
		}
		
		return null;
	}
	
}
