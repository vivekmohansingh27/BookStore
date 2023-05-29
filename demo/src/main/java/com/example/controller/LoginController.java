package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LoginDTO;
import com.example.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public  ResponseEntity<Integer> login(@RequestBody LoginDTO loginDTO){
		
		Integer key = loginService.logIntoAccount(loginDTO);
		
		return new ResponseEntity<Integer>(key,HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public String logout(@RequestParam(required = false) Integer key) {
		String str = loginService.logOutFromAccount(key);
		return str;
	}
	
}
