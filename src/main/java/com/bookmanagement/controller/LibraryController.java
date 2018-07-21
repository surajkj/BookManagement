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
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.service.LibraryService;
import com.bookmanagement.vo.LibraryVo;

@RestController
@RequestMapping("/{userId}/library")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@GetMapping
	public List<LibraryVo> getLibraries(@PathVariable("userId") Long userId){
		return libraryService.getLibraries(userId);
	}
	
	@GetMapping("/{libraryId}")
	public LibraryVo getLibraryById(@PathVariable("libraryId") Long libraryId) {
		return libraryService.getLibraryById(libraryId);
	}
	
	@PostMapping
	public ResponseEntity<LibraryVo> addLibrary(@PathVariable("userId") Long userId,
			@RequestBody LibraryVo libraryVo) {
		libraryVo.setUserId(userId);
		Long libraryId = libraryService.addLibrary(libraryVo);
		libraryVo.setLibraryId(libraryId);
		return new ResponseEntity<LibraryVo>(libraryVo,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<LibraryVo> updateLibrary(@PathVariable("userId") Long userId,
			@RequestBody LibraryVo libraryVo) {
		LibraryVo updatedLibraryVo=libraryService.updateLibrary(libraryVo);
		updatedLibraryVo.setUserId(userId);
		return new ResponseEntity<LibraryVo>(updatedLibraryVo,HttpStatus.OK);
	}
	
	@DeleteMapping("/{libraryId}")
	public ResponseEntity<Long> deleteLibrary(@PathVariable("libraryId") Long libraryId) {
		libraryService.deleteLibrary(libraryId);
		return new ResponseEntity<Long>(libraryId,HttpStatus.OK);
	}
}
