package com.ss.securitydb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// unique : 사용자 이름은 중복 허용x
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	private boolean enabled;		// 계정활성화 -> 1: 활성화, 0: 비활성화
	
	// join 어노테이션
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private List<Role> roles;
}
