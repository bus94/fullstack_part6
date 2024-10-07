package com.ss.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	@Column
	private String id;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private Integer age;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String address;
	@Column
	private String gender;
	@Column
	private String hobby;
//	@Column
//	private String status;
//	@Column
//	private Date enroll_date;
//	@Column
//	private Date modify_date;
}
