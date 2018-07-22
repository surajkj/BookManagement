package com.bookmanagement.vo;

public class AddBookInLibraryVo {
	
	private Long libraryId;
	private Long bookId;
	private Long userId;
	
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AddBookInLibraryVo [libraryId=" + libraryId + ", bookId=" + bookId + ", userId=" + userId + "]";
	}
	
}
