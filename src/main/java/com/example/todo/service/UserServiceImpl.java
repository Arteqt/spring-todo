package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.dao.UserDAO;
import com.example.todo.models.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public void persistUser(User user) {
		userDAO.persistUser(user);
	}

	@Override
	@Transactional
	public User findUserById(String id) {
		return userDAO.findUserById(id);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}
	
	/*@Override
    @Transactional
    public List<User> listUsers() {
        return userDAO.listUsers();
    }*/

}
