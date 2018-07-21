package com.bookmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookmanagement.model.Book;
import com.bookmanagement.model.User;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks(Long userId) {
		String hql = "FROM Book where user_id="+userId;
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Book getBookById(Long bookId) {
		return entityManager.find(Book.class, bookId);
	}

	@Override
	public Long addBook(Book book) {
		entityManager.persist(book);
		entityManager.flush();
		return book.getBookId();
	}

	@Override
	public Book updateBook(Book book) {
		Book updatedBook = getBookById(book.getBookId());
		updatedBook.setName(book.getName());
		updatedBook.setAuthor(book.getAuthor());
		updatedBook.setGenre(book.getGenre());
		entityManager.flush();
		return updatedBook;
	}

	@Override
	public void deleteBook(Long bookId) {
		entityManager.remove(getBookById(bookId));
	}
	
	
}
