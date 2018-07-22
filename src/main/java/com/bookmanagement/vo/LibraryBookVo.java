package com.bookmanagement.vo;

import java.util.List;

public class LibraryBookVo {
	
	private Long libraryBookId;
	private Long libraryId;
	private String libraryName;
	private Long bookId;
	private List<BookVo> bookList;
	
	public Long getLibraryBookId() {
		return libraryBookId;
	}
	public void setLibraryBookId(Long libraryBookId) {
		this.libraryBookId = libraryBookId;
	}
	public Long getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
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
		return "LibraryBookVo [libraryBookId=" + libraryBookId + ", libraryId=" + libraryId + ", libraryName="
				+ libraryName + ", bookId=" + bookId + ", bookList=" + bookList + "]";
	}
	
}
