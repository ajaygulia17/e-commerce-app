package com.e_commerce_app.dto;

public class UserDTO {

	private Long id;
	private String username;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDTO(Long id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}