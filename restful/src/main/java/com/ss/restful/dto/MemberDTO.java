package com.ss.restful.dto;

import com.ss.restful.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private Integer no;
	private String id;
	private String password;
	private String name;
	private Integer age;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private String hobby;
//	private String status;
//	private Date enroll_date;
//	private Date modify_date;
	
	public Member toEntity() {
		return new Member(no, id, password, name, age, email, phone, address, gender, hobby);
	}
}
