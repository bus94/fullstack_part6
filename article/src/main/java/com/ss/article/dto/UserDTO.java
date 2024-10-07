package com.ss.article.dto;

import com.ss.article.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private Long id;
	private String name;
	private String birthday;
	private String phone;
	
	public User toEntity() {
		return new User(id, name, birthday, phone);
	}
}
