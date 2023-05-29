package com.example.service;

import java.util.List;

import com.example.exception.BookException;
import com.example.model.Book;

public interface BookService {

	   public Book createBook(Book book,Integer sessionId)throws BookException;
	   
	   public Book getBookByISBN(Integer isbn)throws BookException;
	  
	   public List<Book> searchBooks(String title, String author)throws BookException;
	   
	   public List<Book> getAllBooks()throws BookException;
	   
	   public Book updateBook(Book book,Integer sessionId)throws BookException;
	   
	   public Book deleteBookByISBN(Integer isbn,Integer sessionId)throws BookException;
	}
