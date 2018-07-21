package com.bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.BookDao;
import com.bookmanagement.dao.UserDao;
import com.bookmanagement.model.Book;
import com.bookmanagement.model.User;
import com.bookmanagement.utility.ApplicationConstants;
import com.bookmanagement.utility.DateUtility;
import com.bookmanagement.vo.BookVo;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	@Autowired
	private UserDao userDao;

	@Override
	public List<BookVo> getBooks(Long userId) {
		List<Book> bookList = bookDao.getBooks(userId);
		List<BookVo> bookVoLst = new ArrayList<BookVo>();
		if(bookList!=null) {
			for (Book book : bookList) {
				BookVo bookVo = new BookVo();
				bookVo.setBookId(book.getBookId());
				bookVo.setUserId(book.getUser().getUserId());
				bookVo.setBookName(book.getName());
				bookVo.setAuthor(book.getAuthor());
				bookVo.setGenre(book.getGenre());
				bookVoLst.add(bookVo);
			}
			return bookVoLst;
		}
		return null;
	}

	@Override
	public BookVo getBookById(Long bookId) {
		Book book= bookDao.getBookById(bookId);
		if(book!=null) {
			BookVo bookVo = new BookVo();
			bookVo.setBookId(book.getBookId());
			bookVo.setBookName(book.getName());
			bookVo.setAuthor(book.getAuthor());
			bookVo.setGenre(book.getGenre());
			bookVo.setUserId(book.getUser().getUserId());
			return bookVo;
		}
		return null;
	}

	@Override
	public Long addBook(BookVo bookVo) {
		try {
			Book book = new Book();
			User user=userDao.getUserById(bookVo.getUserId());
			book.setAuthor(bookVo.getAuthor());
			book.setGenre(bookVo.getGenre());
			book.setName(bookVo.getBookName());
			book.setUser(user);
			book.setCreatedDate(DateUtility.getCurrentDate());
			book.setIsActive(ApplicationConstants.IS_ACTIVE);
			Long bookId=bookDao.addBook(book);
			return bookId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BookVo updateBook(BookVo bookVo) {
		try {
			Book book = new Book();
			book.setBookId(bookVo.getBookId());
			book.setName(bookVo.getBookName());
			book.setAuthor(bookVo.getAuthor());
			book.setGenre(bookVo.getGenre());
			Book updatedBook = bookDao.updateBook(book);
			bookVo.setUserId(updatedBook.getUser().getUserId());
			return bookVo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBook(Long bookId) {
		bookDao.deleteBook(bookId);
	}
	
	
	
}
