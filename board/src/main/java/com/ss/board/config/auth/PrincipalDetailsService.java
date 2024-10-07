package com.ss.board.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ss.board.entity.Users;
import com.ss.board.repository.UserRepository;

public class PrincipalDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByUsername(username);
		
		if(user == null) {
			return null;
		}
		return new PrincipalDetails(user);
	}
	
}
