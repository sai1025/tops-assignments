package com.emp.dto;

public class LoginDTO {

	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
