package com.mycompany.myspringrestfulwebapp.springmvc.controller;


import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myspringrestfulwebapp.springmvc.bean.User;
import com.mycompany.myspringrestfulwebapp.springmvc.service.UserService;

/**
 * Handles requests for User registration.
 */
@RestController
public class UserController {
	
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	UserService userService = new UserService();
	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to the User Spring REST Example.";
    }
	
	/**
	 * endpoint to add a User
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.POST, headers = "Accept=application/json")
	public User addUser(@RequestBody User user) {
		logger.info("Now adding a user");
		return userService.addUser(user);		
	}
	
	/*
	 * endpoint to get information on a registered user based on their username
	 */
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserByUserName(@PathVariable String username) {
		logger.info("Now getting a user by userName");
		return userService.getUser(username);
	}
	
	/*
	 * endpoint to delete a user based on their username
	 */
	@RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	 public void deleteUser(@PathVariable("username") String username) {
	 userService.deleteUser(username);
	}
	
	/*
	 * endpoint to list all users
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> listAllUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}
	
}

