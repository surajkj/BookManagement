package com.bookmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bookmanagement.model.Book;
import com.bookmanagement.model.Library;
import com.bookmanagement.model.LibraryBook;

@Repository
@Transactional
public class BookLibraryDaoImpl implements BookLibraryDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LibraryBook> getAllLibraryBooks(Long libraryId) {
		String hql = "FROM LibraryBook where library_id = :libraryId ";
		return (List<LibraryBook>) entityManager.createQuery(hql)
				.setParameter("libraryId", libraryId)
				.getResultList();
	}
	
	@Override
	public Long addBookToLibrary(LibraryBook libraryBook) {
		entityManager.persist(libraryBook);
		entityManager.flush();
		return libraryBook.getLibraryBookId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LibraryBook getBookByLibraryBookId(Long libraryId,Long bookId) {
		String hql = "FROM LibraryBook where library_id = :libraryId and book_id = :bookId ";
		List<LibraryBook> libraryBookList = entityManager.createQuery(hql)
				.setParameter("libraryId", libraryId)
				.setParameter("bookId", bookId)
				.getResultList();
		System.out.println("Size of book check "+libraryBookList.size());
		
		if(libraryBookList.size()>0) {
			return libraryBookList.get(0);
		}else {
		return null;
		}
	}

//	@Override
//	public void deleteBookFromLibrary(Long libraryBookId) {
//		entityManager.remove(getLibraryBookById(libraryBookId));
//	}
//
//	@Override
//	public LibraryBook getLibraryBookById(Long libraryBookId) {
//		return entityManager.find(LibraryBook.class, libraryBookId);	
//	}
//	
//	public LibraryBook getBookById(Library library,Book book) {
//		return null;
//	}

}
