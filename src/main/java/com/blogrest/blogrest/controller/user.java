package com.blogrest.blogrest.controller;

public class user {
	 private String userName;
	    private String userEmail;
	    private String userPassword;

	    public user(String userName, String userEmail, String userPassword){
	        this.userName = userName;
	        this.userEmail = userEmail;
	        this.userPassword = userPassword;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUsername(String userName) {
	        this.userName = userName;
	    }

	    public String getEmail() {
	        return userEmail;
	    }

	    public void setEmail(String userEmail) {
	        this.userEmail = userEmail;
	    }

	    public String getPassword() {
	        return userPassword;
	    }

	    public void setPassword(String userPassword) {
	        this.userPassword = userPassword;
	    }
}
