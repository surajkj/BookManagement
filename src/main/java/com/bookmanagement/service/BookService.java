package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.model.Book;
import com.bookmanagement.vo.BookVo;

public interface BookService {
	
	public List<BookVo> getBooks(Long userId);
	
	public BookVo getBookById(Long bookId);
	
	public Long addBook(BookVo bookVo);
	
	public BookVo updateBook(BookVo bookVo);
	
	public void deleteBook(Long bookId);
	
}
