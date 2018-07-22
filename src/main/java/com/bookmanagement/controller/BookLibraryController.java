package com.bookmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.service.BookLibraryService;
import com.bookmanagement.vo.BookVo;
import com.bookmanagement.vo.LibraryBookVo;

@RestController
@RequestMapping("/{userId}/librarybook")
public class BookLibraryController {
	
	@Autowired
	BookLibraryService bookLibraryService;
	
	@GetMapping("/{libraryId}")
	public LibraryBookVo getBooksInLibrary(@PathVariable("userId") Long userId,
			@PathVariable("libraryId") Long libraryId) {
		return bookLibraryService.getBooksInLibrary(userId, libraryId);
	}
	
	@PostMapping()
	public ResponseEntity<LibraryBookVo> addBookToLibrary(@PathVariable("userId") Long userId,
			@RequestBody LibraryBookVo libraryBookVo){
		Long libraryBookId = bookLibraryService.addBookInLibrary(libraryBookVo);
		libraryBookVo.setLibraryBookId(libraryBookId);
		return new ResponseEntity<LibraryBookVo>(libraryBookVo,HttpStatus.OK);
	}
	
	
}
