package com.ss.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	// 스프링 시큐리티를 이용해서 로그인을 할 때는 우리가 가입한 비밀번호를 입력하면 된다.
	// 비밀번호를 암호화 하는 설정!
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// 비밀번호 암호화를 위한 설정
		return new BCryptPasswordEncoder();
	}

	// HttpSecurity Http 요청에 대한 보안 설정
	// csrf() : 웹 애플리케이션 보안 취약점 중 하나에 대한 공격을 방지하는 보안 기능 활성화
	// authorizeRequests() : 각 경로에 대한 권한 설정
	// antMatchers() : 특정 url에 대한 접근 권한을 설정
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		// csrf() 비활성화시키기
		//										 // 회원가입, 로그인과 관련없는 경로는 인증없이 접근하도록 설정
//		http.csrf().disable().authorizeRequests().antMatchers("/join", "/joinPro").permitAll().antMatchers("/user", "/admin").authenticated().anyRequest().permitAll().and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
												 // /user 경로는 인증된 사용자만 접근 가능			  // /admin 경로는 ADMIN 권한을 가진 자만 접근 가능																																																			 		// 로그아웃 시 url 설정 // 로그아웃 성공 시 이동할 페이지 // 누구나 로그아웃 가능
		http.csrf().disable().authorizeRequests().antMatchers("/user/**").authenticated().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").antMatchers("/manager/**").access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')").anyRequest().permitAll().and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
		// hasRole() : 특정 경로에 대해 사용자 권한을 확인하고 조건에 맞는 사용자만 접근할 수 있도록 설정하는 메서드
		// formLogin() : 로그인 폼을 설정하는 것
		// loginPage() : 내가 만든 로그인 페이지로 이동
		// defaultSuccessUrl() : 로그인 성공 시 이동할 경로
		
		// 위에서 loginPage()를 이용하여 /login 경로 말고 내가 직접 원하는 경로를 작성하고 싶을 땐
		// loginProcessingURL("경로")
		return http.build();
	}
}
/*
 * ================================
 *  formLogin() 
 *  로그인 페이지의 경로, 로그인 성공시 이동할
 *   경로를 설정 메서드
 *   
 *  loginPage("경로")
 *   - 경로에 있는 로그인 페이지로 리다이렉트
 *    하여 로그인 처리를 할 수있도록 설정
 *  
 *  defaultSuccessUrl("경로")
 *   - 리다이렉트할 경로 설정 로그인 성공시!
 * ================================
 * 
 * Spring Security
 * - Spring에서 제공하는 애플리케이션의 보안(권한, 인증, 인가)를 담당하는 프레임워크
 * 
 * 인증(Authentication)
 * - 해당 사용자가 본인이 맞는지 확인하는 절차
 * 
 * 인가(Authorization)
 * - 인증된 사용자가 요청된 자원에 접근 가능한지 결정하는 절차
 * 
 * Spring Security 특징
 * - Filter를 기반으로 동작한다.
 * 	 Spring mvc와 분리되어 관리하고 동작할 수 있다.
 * - Bean으로 설정한다.
 * - 스프링 부트는 session을 사용한 로그인 구현해서 세션을 통한 로그인 방법!
 * - 로그인이 성공 시에는 spring security session에 저장 한다.
 * - Authentication 타입으로 저장을 해야한다.
 * - UserDetail 이용해서 유저의 정보를 먼저 저장한 후
 * 	 spring security session(Authentication(UserDetail))
 * 
 * spring security 실행 순서
 * 1. Http Request 수신
 * → 사용자가 로그인 정보와 함께 인증을 요청한다.
 * 2. 유저 자격을 기반으로 인증 토큰 생성
 * → AuthenticationFilter가 요청을 가로채고, 가로챈 정보를 통해 UsernamePasswordAuthenticationToken 인증용 객체를 생성한다.
 * 3. Filter를 통해 AuthenticationToken을 관리하는 매니저에게 보낸다.
 * → AuthenticationTokenManager한테 보낸다.
 * 4. 사용자 정보 인증을 시도!
 * 5. UserDetail 구현한 서비스에서 실제 DB에서 사용자 인증 정보를 가져올 수 있도록 한다.
 * 6. 위에서 User를 찾았다면 User 객체에 저장한다.
 * 7. 인증 객체, 예외가 발생할 수 있다.
 * 8. 인증 끝
 * 9. securityContext에 인증 객체를 설정한다.
 */
