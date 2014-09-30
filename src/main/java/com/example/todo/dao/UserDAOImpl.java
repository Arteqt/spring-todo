package com.example.todo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.todo.models.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public User findUserById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}
	@SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
        List<User> userList = sessionFactory.getCurrentSession().createQuery("from USER").list();
        return userList;
	}
	
	
}
