package com.ss.securitydb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ss.securitydb.entity.Role;
import com.ss.securitydb.entity.Users;
import com.ss.securitydb.repository.RoleRepository;
import com.ss.securitydb.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	// 회원가입 하는 함수
	public void joinUserWithRole(Users user, String role) {
		// 1. 비밀번호 암호화
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		
		// 2. 사용자 정보 저장
		userRepository.save(user);
		
		// 3. 선택한 역할에 따라 admin → ROLE_ADMIN 저장
		Role userRole = new Role();
		userRole.setRole(role);
		// 테이블끼리 연결
		// 	setUserId(user.getId())
		//	setUserName(user.getName())
		userRole.setUsername(user.getUsername());
		
		if(role.equals("ADMIN")) {
			userRole.setRole("ROLE_ADMIN");
		} else {
			userRole.setRole("ROLE_USER");
		}
		
		// 4. role DB에 저장
		roleRepository.save(userRole);
	}
	
	// username으로 조회하는 함수
	
	// DB에 저장된 암호화된 비밀번호와 비교하는 함수
	// 첫번째 매개변수: DB에 저장된 사용자 객체. 비밀번호는 이미 암호화!
	public boolean checkPassword(Users user, String loginPassword) {
		return passwordEncoder.matches(loginPassword, user.getPassword());
	}
	
	// 역할(role)을 조회하는 함수 (user, manager, admin 등)
	public boolean hasRole(String name, String role) {
		// 1. 사용자 정보를 가져오는 것
		Users user = userRepository.findByUsername(name);
		
		// 2. 해당 사용자의 역할 목록을 반복하면서 특정 역할이 있는지 확인
		for(Role r : user.getRoles()) {
			if(r.getRole().equals(role)) {
				return true;
			}
		}
		/*
		 * 자바 스트림 API
		 * user.getRoles().stream().anyMatch(r->r.getRole().equals(role))
		 * 
		 */
		
		// 권한이 없으면 false 반환
		return false;
	}
}
