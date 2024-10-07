package com.ss.junit.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name; // 이름
	
	@NonNull
	private String email; // 이메일
	
	@NonNull
	private String password; // 비밀번호
	
	@Column(name = "create_at")
	private LocalDateTime createAt;
	@Column(name = "update_at")
	private LocalDateTime updateAt;
}
