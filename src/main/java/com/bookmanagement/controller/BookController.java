package com.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.service.BookService;
import com.bookmanagement.vo.BookVo;
import com.bookmanagement.vo.UserVo;

@RestController
@RequestMapping("/{userId}/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping()
	public List<BookVo> getAllBooks(@PathVariable("userId") Long userId){
		return bookService.getBooks(userId);
	}
	
	@GetMapping("/{bookId}")
	public BookVo getBookById(@PathVariable("bookId") Long bookId) {
		return bookService.getBookById(bookId);
	}
	
	@PostMapping
	public ResponseEntity<BookVo> addBook(@PathVariable("userId") Long userId,
			@RequestBody BookVo bookVo){
		bookVo.setUserId(userId);
		Long bookId = bookService.addBook(bookVo);
		bookVo.setBookId(bookId);
		return new ResponseEntity<BookVo>(bookVo,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<BookVo> updateBook(@PathVariable("userId") Long userId,
			@RequestBody BookVo bookVo) {
		BookVo updatedBook = bookService.updateBook(bookVo);
		bookVo.setUserId(updatedBook.getUserId());
		return new ResponseEntity<BookVo>(bookVo,HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Long> deleteBook(@PathVariable("bookId") Long bookId) {
		bookService.deleteBook(bookId);
		return new ResponseEntity<Long>(bookId,HttpStatus.OK);
	}
	
}
