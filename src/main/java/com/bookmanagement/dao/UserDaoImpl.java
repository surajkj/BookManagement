package com.bookmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookmanagement.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		String hql = "FROM User ";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(Long userId) {		
		return entityManager.find(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(User user) {
		User updatedUser = getUserById(user.getUserId());
		updatedUser.setName(user.getName());
		updatedUser.setDob(user.getDob());
		entityManager.flush();
	}

	@Override
	public void deleteUser(Long userId) {
		entityManager.remove(getUserById(userId));
		
	}

}
