package com.ss.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 기본적으로 스프링프레임워크에서 시큐리티
// 스프링 시큐리티 버전이 5.7이하
// WebSecurityConfigurerAdapter
// @EnableWebSecurity 어노테이션 이용해서 시큐리티 설정을 등록을 해야한다.

// 스프링 프레임워크에서 시큐리티
// 스프링부트 2.7.x 버전들은 스프링시큐리티 버전 5.7이상은 쓰고 있다.

// @EnableWebSecurity 버전 낮을 때만 사용!
@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain fillter(HttpSecurity http) throws Exception {
		http.csrf().disable() // CSRF 보호 비활성화
				.cors().and() // CORS허용
				.authorizeHttpRequests().antMatchers("/products/login", "/products/register").permitAll().anyRequest()
				.authenticated();

		return http.build();
	}

	// 자격증명을 하는 매니저 객체를 생성할 수 있도록 빈에 등록을 해야된다.
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		System.out.println("매니저 등록됨!");
		return configuration.getAuthenticationManager(); // AuthenticationManager 빈 등록
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // 비밀번호 암호화 방식 설정
	}
}
