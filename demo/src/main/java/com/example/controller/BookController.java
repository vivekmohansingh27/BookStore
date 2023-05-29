package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bs;
	
	@PostMapping("/Books/{id}")
	public ResponseEntity<Book> addBook(@RequestBody Book book,@PathVariable("id") Integer id ){
		Book b = bs.createBook(book,id);
		
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/Books/{isbn}")
	public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") Integer isbn  ){
		
		return new ResponseEntity<>(bs.getBookByISBN(isbn),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/Books")
	public ResponseEntity<List<Book>> getAllBooks(){
		
		return new ResponseEntity<List<Book>>(bs.getAllBooks(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/Books/{title}/{author}")
	public ResponseEntity<List<Book>> searchBook(@PathVariable("title") String title,@PathVariable("author") String author){
		
		return new ResponseEntity<List<Book>>(bs.searchBooks(title,author),HttpStatus.OK);
	}
	
	
	
	@PutMapping("/Books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") Integer id ){
		
		return new ResponseEntity<>(bs.updateBook(book,id),HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/Book/{isbn}/{id}")
	public ResponseEntity<Book> deleteCategoryById(@PathVariable("isbn") Integer isbn,@PathVariable("id") Integer id){
		
		return new ResponseEntity<>(bs.deleteBookByISBN(isbn,id),HttpStatus.OK);
	}

}
