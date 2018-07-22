package com.bookmanagement.service;

import com.bookmanagement.vo.AddBookInLibraryVo;
import com.bookmanagement.vo.LibraryBookVo;

public interface BookLibraryService {
	
	public LibraryBookVo getBooksInLibrary(Long userId,Long libraryId);
	
	public Long addBookInLibrary(AddBookInLibraryVo addBookInLibraryVo);
}
