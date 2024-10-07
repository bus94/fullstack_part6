package com.ss.aop.ex.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ss.aop.it.dto.Employee;

@Component
@Aspect
public class EmployeeAspect {
	@Before("execution(* com.ss.aop.ex.controller.ExService.doEmployee(..)) && args(em)")
	public void info(Employee em) {
		System.out.println("Aspect: " + em);
	}
}
