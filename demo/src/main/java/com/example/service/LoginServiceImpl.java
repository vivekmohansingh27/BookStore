package com.example.service;

import java.time.LocalDateTime;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.LoginException;
import com.example.model.CurrentSession;
import com.example.model.LoginDTO;
import com.example.model.User;
import com.example.repo.CurrentSessionRepo;
import com.example.repo.UserRepo;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepo cRepo;
	
	@Autowired
	private CurrentSessionRepo sRepo;

	@Override
	public Integer logIntoAccount(LoginDTO dto) throws LoginException {
		
		User existingUser= cRepo.findByPhone(dto.getPhone());
		
		if(existingUser == null) {		
			throw new LoginException("Please Enter a valid mobile number");	 
		}
		
		Optional<CurrentSession> validUserSessionOpt =  sRepo.findById(existingUser.getId());
		
		if(validUserSessionOpt.isPresent()) {			
			throw new LoginException("User already Logged In with this number");	
		}
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			
		      int min = 1000; // Minimum value of range
		      int max = 9999; // Maximum value of range
		     
		      int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
			
		      int key= random_int;
			
			
			
			CurrentSession currentSession = new CurrentSession(existingUser.getId(),key,LocalDateTime.now(),existingUser.getRole());
			
			
			
			sRepo.save(currentSession);

			return key;
		}
		else
			throw new LoginException("Please Enter a valid password");
		
	}

	@Override
	public String logOutFromAccount(Integer key) throws com.example.exception.LoginException {
			CurrentSession validCustomerSession = sRepo.findBySessionId(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sRepo.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}
	
	
	
	
}
