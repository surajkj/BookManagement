package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.vo.LibraryVo;

public interface LibraryService {

	public List<LibraryVo> getLibraries(Long userId);
	
	public LibraryVo getLibraryById(Long libraryId);
	
	public Long addLibrary(LibraryVo libraryVo);
	
	public LibraryVo updateLibrary(LibraryVo libraryVo);
	
	public void deleteLibrary(Long libraryId);
}
