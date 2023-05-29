package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer isbn;
	@NotNull
	private String title;
	@NotNull
	private String author;
	@NotNull
	private String description;
	@NotNull
	private Integer price;
	@NotNull
	private LocalDate PublicationDate;
	@NotNull
	private boolean availability;

	public Book(Integer isbn, String title, String author, String description, Integer price, LocalDate publicationDate,
			boolean availability) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		PublicationDate = publicationDate;
		this.availability = availability;
	}

	public Book() {
		super();
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public LocalDate getPublicationDate() {
		return PublicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		PublicationDate = publicationDate;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", PublicationDate=" + PublicationDate + ", availability=" + availability + "]";
	}

	
	
	
	
	
	
	

}
