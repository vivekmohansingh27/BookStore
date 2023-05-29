package com.example.service;

import com.example.exception.BookException;
import com.example.exception.UserException;
import com.example.model.User;

public interface UserService {
 
	public User addUser(User user)throws UserException;
	
	
}
