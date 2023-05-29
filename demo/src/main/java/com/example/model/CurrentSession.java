package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class CurrentSession {
	@Id
	@Column(unique= true)
	private int id;
	
	private int sessionId;
	
	private LocalDateTime localDateTime;
	
	private Role role;

	public CurrentSession(int id, int sessionId, LocalDateTime localDateTime, Role role) {
		super();
		this.id = id;
		this.sessionId = sessionId;
		this.localDateTime = localDateTime;
		this.role = role;
	}

	public CurrentSession() {
		super();
	}
	
	

	
}
