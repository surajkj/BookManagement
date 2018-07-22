package com.bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.BookDao;
import com.bookmanagement.dao.BookLibraryDao;
import com.bookmanagement.dao.LibraryDao;
import com.bookmanagement.dao.UserDao;
import com.bookmanagement.model.Book;
import com.bookmanagement.model.Library;
import com.bookmanagement.model.LibraryBook;
import com.bookmanagement.model.User;
import com.bookmanagement.utility.ApplicationConstants;
import com.bookmanagement.utility.DateUtility;
import com.bookmanagement.vo.BookVo;
import com.bookmanagement.vo.LibraryBookVo;

@Service
public class BookLibraryServiceImpl implements BookLibraryService {
	
	@Autowired
	BookLibraryDao bookLibraryDao;
	@Autowired
	UserDao userDao;
	@Autowired
	LibraryDao libraryDao;
	@Autowired
	BookDao bookDao;
	
	@Override
	public LibraryBookVo getBooksInLibrary(Long userId, Long libraryId) {
		User user = userDao.getUserById(userId);
		if(user!=null) {
			Library library=libraryDao.getLibraryById(libraryId);
			if(library!=null) {
				List<LibraryBook> libraryBookList =
						bookLibraryDao.getAllLibraryBooks(libraryId);
				System.out.println("**** Count of Books in Library **** "+libraryBookList.size());
//				LibraryBookVo libraryBookListVo = new LibraryBookVo();
				List<BookVo> bookVoList = new ArrayList<BookVo>();
				LibraryBookVo libraryBookVo = new LibraryBookVo();
				if(libraryBookList!=null) {
					
					libraryBookVo.setLibraryName(library.getName());
					libraryBookVo.setLibraryId(library.getLibraryId());
					System.out.println("Values in library book "+libraryBookVo.getLibraryName());
					for (LibraryBook libraryBook : libraryBookList) {
						BookVo bookVo= new BookVo();
						Book book = bookDao.getBookById(libraryBook.getBook().getBookId());
						bookVo.setBookId(book.getBookId());
						bookVo.setBookName(book.getName());
						bookVo.setAuthor(book.getAuthor());
						bookVo.setGenre(book.getGenre());
						bookVoList.add(bookVo);
					}
					libraryBookVo.setBookList(bookVoList);
				}
				return libraryBookVo;
			}
		}
		return null;
	}

	@Override
	public Long addBookInLibrary(LibraryBookVo libraryBookVo) {
		LibraryBook libraryBook = new LibraryBook();
		Long libraryBookId=null;
		try {
			Library library = libraryDao.getLibraryById(libraryBookVo.getLibraryId());
			Book book = bookDao.getBookById(libraryBookVo.getBookId());
			if(library!=null) {
				if(book!=null) {
					libraryBook.setBook(book);
					libraryBook.setLibrary(library);
					libraryBook.setCreatedDate(DateUtility.getCurrentDate());
					libraryBook.setIsActive(ApplicationConstants.IS_ACTIVE);
					libraryBookId=bookLibraryDao.addBookToLibrary(libraryBook);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libraryBookId;
	}

	

}
