package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.BookException;
import com.example.model.Book;
import com.example.model.CurrentSession;
import com.example.repo.BookRepo;
import com.example.repo.CurrentSessionRepo;



@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo br;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	@Override
	public Book createBook(Book book,Integer sessionId) {
		
		CurrentSession currentSession = currentSessionRepo.findBySessionId(sessionId);
		if(currentSession==null) throw new BookException("user not found");
		//System.out.println(currentSession.getRole());
		String Role = currentSession.getRole()+"";
		if(Role.equals("admin")==false) throw new BookException("admin not found");
		else{
			if(book==null) throw new BookException("Book not found");
		return	br.save(book);
			
		}
		
	
	}

	@Override
	public Book getBookByISBN(Integer isbn) {
		
		
		Optional<Book> b = br.findById(isbn);
		if(b.isPresent()==false)throw new BookException("Book not found");
		return b.get();
		
	}

	@Override
	public List<Book> searchBooks(String title, String author) {
		List<Book> list = new ArrayList<>();
		
			list = br.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(title, author);
			if(list.isEmpty()) {
				throw new BookException("Books are not found");
			}
			return list;
		
		
		
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		
		list = br.findAll();
		if(list.isEmpty()) {
			throw new BookException("Books are not found");
		}
		return list;
	}

	@Override
	public Book updateBook(Book book,Integer sessionId) {
		
		CurrentSession currentSession = currentSessionRepo.findBySessionId(sessionId);
		if(currentSession==null) throw new BookException("user not found");
		String Role = currentSession.getRole()+"";
		if(currentSession.getRole().equals("admin")==false)  throw new BookException("adimn not found");
		else{
			
			Optional<Book> ob = br.findById(book.getIsbn());
			Book b = ob.get();
			if(b==null)throw new BookException("Book not found");
			b.setAuthor(book.getAuthor());
			b.setDescription(book.getDescription());
			b.setIsbn(book.getIsbn());
			b.setPrice(book.getPrice());
			b.setPublicationDate(book.getPublicationDate());
			b.setTitle(book.getTitle());
			
			br.save(b);
			return book;
		}
		
		
		
	}

	@Override
	public Book deleteBookByISBN(Integer isbn,Integer sessionId) {
		
		CurrentSession currentSession = currentSessionRepo.findBySessionId(sessionId);
		if(currentSession==null) throw new BookException("user not found");
		String Role = currentSession.getRole()+"";
		if(currentSession.getRole().equals("admin")==false)  throw new BookException("admin not found");
		else{
			
			Optional<Book> b = br.findById(isbn);
			if(b.isPresent()==false)throw new BookException("Book not found");
			br.deleteById(isbn);
			return b.get();
		}
		
		
	}
}
