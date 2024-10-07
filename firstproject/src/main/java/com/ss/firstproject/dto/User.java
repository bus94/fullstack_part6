package com.ss.firstproject.dto;

public class User {
	private String id;
	private String email;
	
	public User() {
	}

	public User(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + "]";
	}
	
}
