package com.example.todo.dao;

import com.example.todo.models.User;

public interface UserDAO {
	/* CRUD */
	void persistUser(User user);

	User findUserById(String id);

	void updateUser(User user);

	void deleteUser(User user);

	/*public List<User> listUsers();*/
}
