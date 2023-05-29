package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserException;
import com.example.model.User;
import com.example.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	
	public User addUser(User user) throws UserException {
		if(user==null)throw new UserException("not found");
		userRepo.save(user);
		return user;
		
	}

}
