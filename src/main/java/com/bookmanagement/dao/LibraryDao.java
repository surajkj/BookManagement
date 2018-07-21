package com.bookmanagement.dao;

import java.util.List;

import com.bookmanagement.model.Library;

public interface LibraryDao {
	
	public List<Library> getLibraries(Long userId);
	
	public Library getLibraryById(Long libraryId);
	
	public Long createLibrary(Library library);
	
	public Library updateLibrary(Library library);
	
	public void deleteLibrary(Long libraryId);
	
}
