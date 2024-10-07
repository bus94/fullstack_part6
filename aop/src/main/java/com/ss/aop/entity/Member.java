package com.ss.aop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NO")
	private Long no;
	
	// 회원가입 시 
	// 필수적, 기본적으로 null 허용 안함
	// 	id(중복 허용x), pass, name, role, status, enroll_date, modify_date 
	// 선택적
	// 	phone, email, address, boddy, status
	@Column(name = "ID", unique = true, nullable = false)
	private String id;
}
