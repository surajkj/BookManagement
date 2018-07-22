package com.bookmanagement.vo;

public class BookVo {
	
	private Long bookId;
	private Long userId;
	private Long libraryBookId;
	private String bookName;
	private String author;
	private String genre;
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
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Long getLibraryBookId() {
		return libraryBookId;
	}
	public void setLibraryBookId(Long libraryBookId) {
		this.libraryBookId = libraryBookId;
	}
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", userId=" + userId + ", libraryBookId=" + libraryBookId + ", bookName="
				+ bookName + ", author=" + author + ", genre=" + genre + "]";
	}

}
