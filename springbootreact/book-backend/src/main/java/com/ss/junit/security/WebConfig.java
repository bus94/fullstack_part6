package com.ss.junit.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// CORS에 관한 설정을 할 수 있도록!
// 다른 서버에서 요청을 보낼 때 발생하는 보안 문제
// 필요한 만큼 설정이 가능하다

// WebMvcConfigurer
// - CORS 설정 추가하거나 변경할 때 사용하는 인터페이스! 클래스에 구현을 해야한다.

// 만약 CORS 설정하는 것이 어려우면 기존 사용한 컨트롤러 위에 @CrossOrigin, 아래의 코드인 WebConfi는 없어도 된다.

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) { // registry : 어떤 경로에 대해 요청을 허용할 것인지
		// 모든 요청을 허용한다. 		   // 그렇다면 url이 다양할 땐? localhost가 3000일지 9090일지 등등								 // 인증 정보 허용(쿠키 등)	 // 모든 헤더 허용		// 캐시 설정 시간 (3600=1시간 동안 어떤 요청에 대해 CORS 설정 확인 없이 그대로 허용)
		registry.addMapping("/**").allowedOrigins("http://localhost:3000/").allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true).allowedHeaders("*").maxAge(3600);
	}
}
