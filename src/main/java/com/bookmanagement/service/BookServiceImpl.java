package com.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.BookDao;
import com.bookmanagement.model.Book;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}

	@Override
	public Book getBookById(Long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
