package com.ss.junit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	// 자격증명을 하는 매니저 객체를 생성할 수 있도록 빈에 등록을 해야한다.
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		System.out.println("매니저 등록됨!");
        return configuration.getAuthenticationManager(); // AuthenticationManager 빈 등록
    }
	
	@Bean // 스프링부트에 시큐리티에 대한 설정 등록!
			// SecurityFilterChain 보안설정 필터
			// 어떤 경로로 보호, 어떤 경로가 열려있는지 등의 보안에 관한 설정 역할
			// HttpSecurity 웹에 들어왔을 때
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
		// http 요청이 들어오는 웹 보안 설정
		http.csrf().disable() // 보호 기능 비활성화
				.cors().and() // cors() 허용 : 외부 자바스크립트 내용을 허용 (컨트롤러의 @CrossOrigin과 같이 시큐리티에서 허용하는 방법)
				.authorizeRequests() // authorizeRequests() : 누가 어떤 페이지로 접근할 수 있는지 설정
				.antMatchers("/", "/book/**") // antMatchers("허용할 url 기입")
				.permitAll().anyRequest().authenticated();
		// and() login() loginpage()
		// and() logout().permitAll()
		return http.build();
	}

	// 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEn() {
		return new BCryptPasswordEncoder();
	}
}
