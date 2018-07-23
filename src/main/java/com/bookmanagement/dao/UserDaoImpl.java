package com.bookmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookmanagement.model.LibraryBook;
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
	public Long addUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getUserId();
	}

	@Override
	public void updateUser(User user) {
		entityManager.flush();
	}

	@Override
	public void deleteUser(Long userId) {
		entityManager.remove(getUserById(userId));
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUserName(String userName) {
		String hql = "FROM User where user_name = :userName";
		List<User> userList = entityManager.createQuery(hql)
				.setParameter("userName", userName)
				.getResultList();

		if(userList.size()>0) {
			return userList.get(0);
		}else {
		return null;
		}
	}

}
