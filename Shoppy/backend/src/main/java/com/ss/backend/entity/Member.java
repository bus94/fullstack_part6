package com.ss.backend.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;

	@Column(name = "create_at", nullable = false)
	private LocalDateTime createAt;

	@Column(name = "update_at", nullable = false)
	private LocalDateTime updateAt;

	// 생성될 때 자동으로 현재 시간을 설정
	@PrePersist
	public void prePersist() {
		this.createAt = LocalDateTime.now();
		this.updateAt = LocalDateTime.now();
	}

	// 업데이트 시 update_at 값을 갱신
	@PreUpdate
	public void preUpdate() {
		this.updateAt = LocalDateTime.now();
	}

}
