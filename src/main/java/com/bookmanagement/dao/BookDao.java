package com.bookmanagement.dao;

import java.util.List;

import com.bookmanagement.model.Book;

public interface BookDao {
	
	public List<Book> getBooks(Long userId);
	
	public Book getBookById(Long bookId);
	
	public Long addBook(Book book);
	
	public Book updateBook(Book book);
	
	public void deleteBook(Long bookId);
	
}
