package com.bookmanagement.dao;

import java.util.List;

import com.bookmanagement.model.LibraryBook;

public interface BookLibraryDao {
	
	public List<LibraryBook> getAllLibraryBooks(Long libraryId);
	
	public Long addBookToLibrary(LibraryBook libraryBook);
	
	public LibraryBook getBookByLibraryBookId(Long libraryId,Long bookId);
}
