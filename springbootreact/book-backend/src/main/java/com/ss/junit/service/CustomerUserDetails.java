package com.ss.junit.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ss.junit.entity.Member;

public class CustomerUserDetails implements UserDetails{
	
	private Member member;
	
	// 생성자를 이용해서 Member에 대한 데이터를 주입 받는다.
	// 생성자 주입!
	public CustomerUserDetails(Member member) {
		this.member = member;
	}

	// 스프링 시큐리티에서 권한(roles) 알려주는 메서드
	// 사용자 권한을 확인하기 위해서 getAuthorities()
	// 실행순서: 시큐리티가 실행되면 getAutorities() 메서드가 실행되고, User인지 확인되면 ROLE_USER 권한이 부여되는 것이다. (ex. Admin 설정해두면 ROLE_ADMIN 권한이 부여될 것이다)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 여기서 User 역할만 저장
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return member.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; // 계정 만료 여부 true면 만료되지 않았다.
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true; // 계정 잠금 여부 true면 잠기지 않았다.
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true; // 비밀번호 만료여부 true면 만료되지 않았다.
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true; // 계정 활성화 여부
	}
	
}
