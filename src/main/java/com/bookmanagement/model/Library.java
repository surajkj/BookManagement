package com.bookmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class Library {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="library_id")
	private Long libraryId;

}
