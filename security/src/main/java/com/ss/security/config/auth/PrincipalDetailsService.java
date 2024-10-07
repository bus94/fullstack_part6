package com.ss.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss.security.entity.Users;
import com.ss.security.repository.UserRepository;

// UserDetailsService
// 		사용자 인증 정보 제공하는 인터페이스
//		사용자의 요청을 처리하기 위해서 DB에서 사용자의 정보를 가지고 오는 것!
@Service
public class PrincipalDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByUsername(username);

		// user가 없으니 null로 반환해서 로그인을 못하게 한다.
		if (user == null) {
			return null;
		}
		
		// Spring Security 에서 사용할 수 있는 UserDetails 객체로 반환한다.
		// 인증된 사용자 정보를 다루기 위해서 필요한 객체!
		// Spring security가 사용자 정보에 접근할 수 있도록 한다..
		return new PrincipalDetails(user);
	}
}
