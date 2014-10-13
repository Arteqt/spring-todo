package com.example.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.todo.models.User;
import com.example.todo.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("user", new User());
		return "userPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(User userBean, Model model) {
		userService.persistUser(userBean);
		model.addAttribute("user", "User created");

		return "userPage";
	}

	@ModelAttribute("userBean")
	public User createFormBean() {
		return new User();
	}

	/*@ModelAttribute("users")
	public List<User> getUsers() {
		return userService.listUsers();
	}*/

	@ModelAttribute("userbyid")
	public User getUserById(String id) {
		return userService.findUserById(id);
	}

}
