package com.example.AuthenticationApp.service;
import java.util.Optional;

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
	
	//reset token finding
	User findUserByResetToken(String resetToken);
	//Login User and get details of user
	User findUserByEmail(String email);
	
}
