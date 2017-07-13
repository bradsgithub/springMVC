package com.mycompany.myspringrestfulwebapp.springmvc.controller;

//import org.junit.Assert.assertEquals;
//import org.junit.Assert.assertNotNull;

import org.junit.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mycompany.myspringrestfulwebapp.springmvc.bean.User;
import com.mycompany.myspringrestfulwebapp.springmvc.service.UserService;
/*
 * This is a test class which tests the UserController class containing the Spring based
 * REST endpoints.  The assumption I used was that a Date was passed in as a String
 */
public class UserControllerTest {
	
	@InjectMocks UserController userController;
	@Mock UserService userService;
	@InjectMocks User mockedUser;
	@InjectMocks User mockedReturnUser;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockedUser.setDate("02-28-17");
		mockedUser.setUsername("amy");
		mockedUser.setEmailAddress("test@test.com");
	}
	
	@Test
	public final void testWelcome() {
		String welcomeString = userController.welcome();
		Assert.assertEquals(welcomeString, "Welcome to the User Spring REST Example.");
	}
	
	/*
	 * Test the use case of calling the REST endpoint to add a user and verifying 
	 * that the number of users has increased by 1.
	 */
	@Test
	public final void testAddUser() {
		User user = new User("john", "test1@test.com", "02-25-17");
		UserController uc = new UserController();
		List<User> userList = uc.listAllUsers();
		long length = userList.size();
		uc.addUser(user);
		List<User> userListAfter = uc.listAllUsers();
		long lengthAfter = userListAfter.size();
		
		Assert.assertEquals(length+1, lengthAfter);
	}
	
	/*
	 *  Test that the use case of calling the REST endpoint to get the user
	 *  Verify that the correct user is returned.
	 */
	@Test
	public final void testGetUserByUserName() {
		UserController uc = new UserController();
		User user = new User("bob", "test1@test.com", "02-25-17");
		User userToFind = uc.getUserByUserName(user.getUsername());
		
		Assert.assertEquals(userToFind.getUsername(), user.getUsername());
		Assert.assertEquals(userToFind.getEmailAddress(), user.getEmailAddress());
		Assert.assertEquals(userToFind.getDate(), user.getDate());
	}
	
	/*
	 * Test the use case of calling the REST endpoint to delete a user
	 * Verify that the number of users has decreased by 1.
	 */
	@Test
	public final void testDeleteUser() {
		User user = new User("mary", "test1@test.com", "02-25-17");
		UserController uc = new UserController();
		List<User> userList = uc.listAllUsers();
		long length = userList.size();
		uc.deleteUser(user.getUsername());
		List<User> userListAfter = uc.listAllUsers();
		long lengthAfter = userListAfter.size();
		
		Assert.assertEquals(length-1, lengthAfter);
	}
	
	/*
	 * Testing a utility REST endpoint to list all of the users.
	 * Verify that there are users present.
	 */
	@Test
	public final void testListAllUsers() {
		
		UserController uc = new UserController();
		List<User> userList = uc.listAllUsers();
		Assert.assertNotNull(userList);
	}
	
}