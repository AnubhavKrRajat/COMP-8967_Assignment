package com.example.AuthenticationApp.service;
import com.example.AuthenticationApp.model.User;

public interface UserService {
	
	//Register User
	User saveUser(User user);
	
	//Login User and get details of user
	User fetchUserDetails(String email, String password);
	
	//Existing User Check
	boolean CheckUserAlreadyExist(String email);
	
	//Update User Details
	User updateUser(User user, String email);
	
}
