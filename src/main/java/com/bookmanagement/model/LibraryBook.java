package com.bookmanagement.model;
// Generated 20 Jul, 2018 11:20:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LibraryBook generated by hbm2java
 */
@Entity
@Table(name="library_book"
    ,catalog="bookmanagement"
)
public class LibraryBook  implements java.io.Serializable {


     private Long libraryBookId;
     private Book book;
     private Library library;
     private User user;
     private Date createdDate;
     private Character isActive;

    public LibraryBook() {
    }

    public LibraryBook(Book book, Library library,User user, Date createdDate, Character isActive) {
       this.book = book;
       this.library = library;
       this.user = user;
       this.createdDate = createdDate;
       this.isActive = isActive;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="library_book_id", unique=true, nullable=false)
    public Long getLibraryBookId() {
        return this.libraryBookId;
    }
    
    public void setLibraryBookId(Long libraryBookId) {
        this.libraryBookId = libraryBookId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book_id")
    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="library_id")
    public Library getLibrary() {
        return this.library;
    }
    
    public void setLibrary(Library library) {
        this.library = library;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="is_active", length=1)
    public Character getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}


