package com.bookmanagement.dao;

import java.util.List;

import com.bookmanagement.model.Book;

public interface BookDao {
	
	public List<Book> getBooks();
	
	public Book getBookById(Long bookId);
	
	public Long addBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBook(Long bookId);
	
}
