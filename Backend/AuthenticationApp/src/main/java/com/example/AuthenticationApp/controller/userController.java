package com.example.AuthenticationApp.controller;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import com.example.AuthenticationApp.model.User;
import com.example.AuthenticationApp.service.EmailService;
import com.example.AuthenticationApp.service.UserService;


@RestController
@CrossOrigin(origins = "*")
public class userController {
	@Autowired 
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	
	@PostMapping("/ForgotPassword")
	public ResponseEntity<?> ForgotPassword(@Valid @RequestBody User user) 
	{
		
		User userData = new User();
		
		//finding user through email
		userData = userService.findUserByEmail(user.getEmail());

		if (userData==null) 
		{
			//returning status with message
			return new ResponseEntity<>("No User Found", HttpStatus.CONFLICT);
		} 
		
		else 
		{
			// Generate random 36-character string token for reset password 
			userData.setResetToken(UUID.randomUUID().toString());
			
			// Save token to database	
			userService.saveUser(userData);
						
			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("support@assignment1.com");
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Password Reset Code");
			passwordResetEmail.setText("Your Reset Password Code: " + userData.getResetToken());
			
			//sending email through mail service of java
			emailService.sendEmail(passwordResetEmail);

			//returning http status with message
			return new ResponseEntity<>("Code have been sent to user successfully", HttpStatus.ACCEPTED);
		}

	}
	
	@PutMapping("/ResetPassword")
	private ResponseEntity<?> changePassword(@Valid @RequestBody User user)
	{
		User userData = new User();
		
		//finding user by reset token
		userData = userService.findUserByResetToken(user.getEmail());
		
		if (userData==null) 
		{
			//if not found means incorrect token
			return new ResponseEntity<>("Invalid Token", HttpStatus.CONFLICT);
		} 
		
		else 
		{
			//if found update password in the database
			userService.updateUser(user, userData.getEmail());
			return new ResponseEntity<>("Password Updated Succesfully", HttpStatus.OK);
		}
		
	}
	
	//Registration
    @PostMapping("/RegisterUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user)
    {
    	if(userService.CheckUserAlreadyExist(user.getEmail()))
    	{
    		
    		return new ResponseEntity<>("User Already Exists", HttpStatus.CONFLICT);
    	}
    	
    	else
    	{
    		userService.saveUser(user);
    		return new ResponseEntity<>("User Saved Successfully",HttpStatus.OK);
    	}
    	
    }
    
   // Login User and return user data
    @PostMapping("/LoginUser")
    public ResponseEntity<?> getUserDetailsAndLogin(@Valid @RequestBody User user)
    {
    	User userData = new User();
        userData = userService.fetchUserDetails(user.getEmail(), user.getPassword());
        if(userData!=null)
        {
        	return new ResponseEntity<User>(userData,HttpStatus.OK);
        }
        
        else
        {
        	return new ResponseEntity<>("Incorrect Username or Password",HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/UpdateUser") 
    public ResponseEntity<?> updateUserData(@Valid @RequestBody User user)
    {
    	User userData = new User();
    	userData = userService.updateUser(user, user.getEmail());
    	return new ResponseEntity<User>(userData,HttpStatus.OK);
    }
    	 

}
