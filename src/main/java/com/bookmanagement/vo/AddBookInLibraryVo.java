package com.bookmanagement.vo;

public class AddBookInLibraryVo {
	
	private Long libraryBookId;
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
	public Long getLibraryBookId() {
		return libraryBookId;
	}
	public void setLibraryBookId(Long libraryBookId) {
		this.libraryBookId = libraryBookId;
	}
	@Override
	public String toString() {
		return "AddBookInLibraryVo [libraryBookId=" + libraryBookId + ", libraryId=" + libraryId + ", bookId=" + bookId
				+ ", userId=" + userId + "]";
	}
	
}
