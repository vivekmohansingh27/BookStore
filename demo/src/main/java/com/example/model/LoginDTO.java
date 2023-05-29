package com.example.model;

import lombok.Data;

@Data
public class LoginDTO {

	private String phone;
	private String password;
	private Role role;
}
