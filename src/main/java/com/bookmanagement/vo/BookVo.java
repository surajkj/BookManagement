package com.bookmanagement.vo;

public class BookVo {
	
	private Long bookId;
	private Long userId;
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
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", userId=" + userId + ", bookName=" + bookName + ", author=" + author
				+ ", genre=" + genre + "]";
	}
	
	
}
