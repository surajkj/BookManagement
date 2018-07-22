package com.bookmanagement.vo;

import java.util.List;

public class LibraryBookVo {
	
	private Long libraryId;
	private String libraryName;
	private List<BookVo> bookList;
	
	public Long getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}
	public List<BookVo> getBookList() {
		return bookList;
	}
	public void setBookList(List<BookVo> bookList) {
		this.bookList = bookList;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	@Override
	public String toString() {
		return "LibraryBookVo [libraryId=" + libraryId + ", libraryName=" + libraryName + ", bookList=" + bookList
				+ "]";
	}
	
	
}
