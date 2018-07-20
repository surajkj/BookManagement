package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.model.Book;

public interface BookService {
	
	public List<Book> getBooks();
	
	public Book getBookById(Long bookId);
	
	public Long addBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBook(Long bookId);
	
}
