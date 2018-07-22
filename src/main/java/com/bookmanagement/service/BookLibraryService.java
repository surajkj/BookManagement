package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.vo.AddBookInLibraryVo;
import com.bookmanagement.vo.LibraryBookVo;

public interface BookLibraryService {
	
	public LibraryBookVo getBooksInLibrary(Long userId,Long libraryId);
	
	public List<LibraryBookVo> getBooksInLibraryByUserId(Long userId);
	
	public Long addBookInLibrary(AddBookInLibraryVo addBookInLibraryVo);
	
	public void removeBookFromLibrary(Long libraryBookId);
}
