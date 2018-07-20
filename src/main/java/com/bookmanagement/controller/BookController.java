package com.bookmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.service.BookService;

@RestController
@RequestMapping("/{userid}/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	
}
