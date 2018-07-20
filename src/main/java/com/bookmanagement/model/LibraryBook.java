package com.bookmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library_book")
public class LibraryBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="library_book_id")
	private Long libraryBookId;

}
