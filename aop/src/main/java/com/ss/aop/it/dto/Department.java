package com.ss.aop.it.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 부서에 대한 정보 (부서명, 직원 리스트)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	private String deptName;
	private List<Employee> employees;
	
	// 어떤 직원들이 있는지 확인
	public void meeting() {
		// 이름, 부서명을 출력!
		
	}
}
