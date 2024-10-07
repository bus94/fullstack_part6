package com.ss.aop.it.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// 직원의 정보를 저장하는 클래스
// new 직접 작성을 하게 되면 spring boot에서 빈즈를 관리하지 않기 때문에 aop가 적용이 안될 수도 있다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Component // 스프링 부트가 객체(빈즈)를 관리할 수 있도록 어노테이션 달기 만약 없다면 트랜잭션, aop 적용이 안될 수 있다.
public class Employee {
	@NonNull
	private String name;
	private String department;
	
	// 추가 메서드
	public void work(Employee employee) {
		System.out.println(name + "의 부서: " + department + "에서 일한다.");
	}
}
