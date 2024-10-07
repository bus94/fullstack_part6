package com.ss.aop.it.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Company {
	private List<Department> departments;
	
	public Company() {
		this.departments = new ArrayList<Department>();
	}
	
	public void callForMeeting(String name) {
		// 반복문을 이용해서 전체 dapartments 부서 중에서 name이 해당하는 직원들의 정보를 출력
		
	}
	
	// 추가 작업을 해야되는 대상을 타겟(개발팀)
	// 타겟에 적용하고 싶은 작업을 어드바이스
	// 해야될 일! (지문 인증)
	// 구체적인 위치를 지정(조인포인트)
	// 실제 추가작업을 하는 행위를 간섭, 위빙
	// 위의 실제 구성을 하기 위해서는 지문인증 어드바이스 작성!
	
}
