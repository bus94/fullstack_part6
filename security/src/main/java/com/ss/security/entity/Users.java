package com.ss.security.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String username;
	private String password;
	private String email;
	private String role;
	@CreationTimestamp
	private Timestamp createDate;
	// 엔티티가 생성될 때 마다 자동으로 현재 시간을 기록한다. DB 생성(삽입)될 때
}
