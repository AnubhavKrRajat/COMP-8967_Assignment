package com.example.AuthenticationApp.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.AuthenticationApp.model.User;
import com.example.AuthenticationApp.service.UserService;


@Controller
public class userController {
	@Autowired 
	private UserService userService;
	
	//Registration
	@CrossOrigin
    @PostMapping("/RegisterUser")
    public ResponseEntity saveUser(@Valid @RequestBody User user)
    {
    	if(userService.CheckUserAlreadyExist(user.getEmail())){
    		
    		return new ResponseEntity<>("User Already Exists", HttpStatus.CONFLICT);
    	}
    	else
    	{
    		userService.saveUser(user);
    		return new ResponseEntity<>("User Saved Successfully",HttpStatus.OK);
    	}
    	
    }
    
   // Login User and return user data
	@CrossOrigin
    @PostMapping("/LoginUser")
    @ResponseBody
    public ResponseEntity getUserDetailsAndLogin(@Valid @RequestBody User user)
    {
    	User userData = new User();
        userData = userService.fetchUserDetails(user.getEmail(), user.getPassword());
        if(userData!=null)
        {
        	return new ResponseEntity<>(userData,HttpStatus.OK);
        }
        else
        {
        	return new ResponseEntity<>("Incorrect Username or Password",HttpStatus.NOT_FOUND);
        }
    }
	
	@CrossOrigin
    @PutMapping("/UpdateUser") 
    public ResponseEntity updateUserData(@Valid @RequestBody User user)
    {
    		userService.updateUser(user, user.getEmail());
    		return new ResponseEntity<>("User Info Updated Successfully",HttpStatus.OK);
    	}
    	 

}
