package com.ss.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	// 비밀번호 암호화
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		// index1 페이지는 인증된 사용자만 이용 가능
		// /login/login 페이지에서 로그인이 되었을 때 index1 페이지로 이동
		// logout 시 /login/login 페이지로 이동
		http.csrf().disable().authorizeHttpRequests().antMatchers("/index1").authenticated().anyRequest().permitAll().and().formLogin().loginPage("/login").defaultSuccessUrl("/index1").permitAll().and().logout().logoutUrl("/logoutPro").logoutSuccessUrl("/login").permitAll();
		return http.build();
	} 
}
