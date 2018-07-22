package com.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.service.BookLibraryService;
import com.bookmanagement.vo.AddBookInLibraryVo;
import com.bookmanagement.vo.LibraryBookVo;

@RestController
@RequestMapping("/{userId}/librarybook")
public class BookLibraryController {
	
	@Autowired
	BookLibraryService bookLibraryService;
	
	@GetMapping
	public List<LibraryBookVo> getLibraryBookByUser(@PathVariable("userId") Long userId){
		return bookLibraryService.getBooksInLibraryByUserId(userId);
	}
	
	@GetMapping("/{libraryId}")
	public LibraryBookVo getBooksInLibrary(@PathVariable("userId") Long userId,
			@PathVariable("libraryId") Long libraryId) {
		return bookLibraryService.getBooksInLibrary(userId, libraryId);
	}
	
	@PostMapping
	public ResponseEntity<AddBookInLibraryVo> addBookToLibrary(@PathVariable("userId") Long userId,
			@RequestBody AddBookInLibraryVo addBookInLibraryVo){
		addBookInLibraryVo.setUserId(userId);
		Long libraryBookId = bookLibraryService.addBookInLibrary(addBookInLibraryVo);
		addBookInLibraryVo.setLibraryBookId(libraryBookId);
		return new ResponseEntity<AddBookInLibraryVo>(addBookInLibraryVo,HttpStatus.OK);
	}
	
	@DeleteMapping("/{libraryBookId}")
	public ResponseEntity<Long> removeBookFromLibrary(@PathVariable("userId") Long userId,
			@PathVariable("libraryBookId") Long libraryBookId){
		bookLibraryService.removeBookFromLibrary(libraryBookId);
		return new ResponseEntity<Long>(libraryBookId,HttpStatus.OK);
	}
	
}
