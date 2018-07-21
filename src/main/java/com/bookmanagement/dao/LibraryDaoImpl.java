package com.bookmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookmanagement.model.Book;
import com.bookmanagement.model.Library;

@Transactional
@Repository
public class LibraryDaoImpl implements LibraryDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Library> getLibraries(Long userId) {
		String hql = "FROM Library where user_id="+userId;
		return (List<Library>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Library getLibraryById(Long libraryId) {
		return entityManager.find(Library.class, libraryId);
	}

	@Override
	public Long createLibrary(Library library) {
		entityManager.persist(library);
		entityManager.flush();
		return library.getLibraryId();
	}

	@Override
	public Library updateLibrary(Library library) {
		Library updatedLibrary = getLibraryById(library.getLibraryId());
		updatedLibrary.setName(library.getName());
		entityManager.flush();
		return updatedLibrary;
	}

	@Override
	public void deleteLibrary(Long libraryId) {
		entityManager.remove(getLibraryById(libraryId));
	}

}
