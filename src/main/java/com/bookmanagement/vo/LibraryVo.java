package com.bookmanagement.vo;

import java.util.List;

public class LibraryVo {
	
	private Long libraryId;
	private String libraryName;
	private Long userId;
//	private List<BookVo> bookList;
	
	public Long getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
//	public List<BookVo> getBookList() {
//		return bookList;
//	}
//	public void setBookList(List<BookVo> bookList) {
//		this.bookList = bookList;
//	}
//	@Override
//	public String toString() {
//		return "LibraryVo [libraryId=" + libraryId + ", libraryName=" + libraryName + ", userId=" + userId
//				+ ", bookList=" + bookList + "]";
//	}
	@Override
	public String toString() {
		return "LibraryVo [libraryId=" + libraryId + ", libraryName=" + libraryName + ", userId=" + userId + "]";
	}
		
}
