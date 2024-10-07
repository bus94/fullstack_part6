package com.ss.board.entity;

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
	
	// 회원가입시 id,pass,name,role,status //   phone,email,address,hobby,
	@Column(name="ID", unique = true, nullable = false)
	private String id;
	
	@Column(name="PASS", unique = true, nullable = false)
	private String pass;
	
	@Column(name="NAME", unique = true, nullable = false)
	private String name;
	
	@Column(name="ROLE", unique = true, nullable = false)
	private String role;
	
	@Column(name="STATUS", unique = true, nullable = false)
	private String status;
	
	private Integer phone;
}
