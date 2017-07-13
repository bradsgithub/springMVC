package com.mycompany.myspringrestfulwebapp.springmvc.bean;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public User(String userName, String emailAddress, String string) {
		// TODO Auto-generated constructor stub
		this.username = userName;
		this.emailAddress = emailAddress;
		this.date = string;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", emailAddress=" + emailAddress + ", date=" + date + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String username;
	private String emailAddress;
	private String date;
}
