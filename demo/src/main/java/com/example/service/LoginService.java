package com.example.service;

import com.example.exception.LoginException;
import com.example.model.LoginDTO;

public interface LoginService {

	public Integer logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(Integer key)throws LoginException;
}
