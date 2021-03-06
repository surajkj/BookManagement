package com.bookmanagement.model;
// Generated 20 Jul, 2018 11:20:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name="book"
    ,catalog="bookmanagement"
)
public class Book  implements java.io.Serializable {


     private Long bookId;
     private User user;
     private String name;
     private String author;
     private String genre;
     private Date createdDate;
     private Character isActive;
     private Set<LibraryBook> libraryBooks = new HashSet<LibraryBook>(0);

    public Book() {
    }

    public Book(User user, String name, String author, String genre, Date createdDate, Character isActive, Set<LibraryBook> libraryBooks) {
       this.user = user;
       this.name = name;
       this.author = author;
       this.genre = genre;
       this.createdDate = createdDate;
       this.isActive = isActive;
       this.libraryBooks = libraryBooks;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="book_id", unique=true, nullable=false)
    public Long getBookId() {
        return this.bookId;
    }
    
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="author", length=100)
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    
    @Column(name="genre", length=20)
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="book")
    public Set<LibraryBook> getLibraryBooks() {
        return this.libraryBooks;
    }
    
    public void setLibraryBooks(Set<LibraryBook> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }




}


