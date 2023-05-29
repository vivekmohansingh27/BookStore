package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CurrentSession;

@Repository
public interface CurrentSessionRepo extends JpaRepository<CurrentSession, Integer>{

	public CurrentSession findBySessionId(Integer sessionId);
}
