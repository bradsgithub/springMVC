package com.mycompany.myspringrestfulwebapp.springmvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.mycompany.myspringrestfulwebapp.springmvc.bean.User;
 
/*
 * This class is the service layer for the MVC app.
 * This version does not have persistence but has a simple in-memory data store.
 * 
 */
public class UserService {
 
 static HashMap<String,User> userIdMap=getUserIdMap();
 
 
 public UserService() {
 super();
 
 if(userIdMap==null)
 {
	 userIdMap=new HashMap<String,User>();
	 User firstUser = new User("bob", "test1@test.com", "02-25-17");//new Date());
	 User secondUser = new User("mark", "test2@test.com", "02-25-17");//new Date());
	 User thirdUser = new User("mary", "test3@test.com", "02-25-17");//new Date());
	 User fourthUser = new User("sue", "test4@test.com", "02-25-17");//new Date());
 
	 userIdMap.put("bob",firstUser);
	 userIdMap.put("mark",secondUser);
	 userIdMap.put("mary",thirdUser);
	 userIdMap.put("sue",fourthUser);
 }
 }
 
 public List<User> getAllUsers()
 {
	 List<User> users = new ArrayList<User>(userIdMap.values());
	 return users;
 }
 
 public User getUser(String username)
 {
	 User country= userIdMap.get(username);
	 return country;
 }
 public User addUser(User user)
 {
	 userIdMap.put(user.getUsername(), user);
	 return user;
 }
 
 public User updateUser(User user)
 {
	 if(user.getUsername()=="")
		 return null;
	 userIdMap.put(user.getUsername(), user);
	 return user;
 }
 
 public void deleteUser(String username)
 {
	 userIdMap.remove(username);
 }
 
 public static HashMap<String, User> getUserIdMap() {
	 return userIdMap;
 }
 
}