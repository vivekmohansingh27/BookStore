package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Book;



@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

	
	public List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title,String author);

}
