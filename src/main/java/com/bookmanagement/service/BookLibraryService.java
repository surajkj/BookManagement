package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.vo.LibraryBookVo;

public interface BookLibraryService {
	
	public LibraryBookVo getBooksInLibrary(Long userId,Long libraryId);
	
	public Long addBookInLibrary(LibraryBookVo libraryBookVo);
}
