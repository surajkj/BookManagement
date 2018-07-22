package com.bookmanagement.dao;

import java.util.List;

import com.bookmanagement.model.LibraryBook;

public interface BookLibraryDao {
	
	public List<LibraryBook> getAllLibraryBooks(Long libraryId);
	
	public List<LibraryBook> getAllLibraryBooksByUserId(Long userId);
	
	public Long addBookToLibrary(LibraryBook libraryBook);
	
	public LibraryBook getBookByLibraryBookId(Long libraryId,Long bookId);
	
	public void removeBookFromLibrary(Long libraryBookId);
	
	public LibraryBook getBookById(Long libraryBookId);
}
