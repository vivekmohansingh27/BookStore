package com.example.exception;

public class BookException extends RuntimeException{
	public BookException(){
		super();
	}
	
	public BookException(String msg){
		super(msg);
	}

}