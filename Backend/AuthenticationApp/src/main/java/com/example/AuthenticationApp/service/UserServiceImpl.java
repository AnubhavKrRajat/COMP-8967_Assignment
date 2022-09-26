package com.example.AuthenticationApp.service;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuthenticationApp.model.User;
import com.example.AuthenticationApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	UserRepository userRepository;
	
	User userModel;
	
	@Override
	public User saveUser(User user) 
	{
		userModel = new User();
		if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) 
	    {
			userModel.setName(user.getName());
	    }
	        
	    if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) 
	    {
	    	userModel.setEmail(user.getEmail());
	    }
	        
	    if (Objects.nonNull(user.getPhoto()) && !"".equalsIgnoreCase(user.getPhoto())) 
	    {
	    	userModel.setPhoto(user.getPhoto());
	    }
	        
	    if (Objects.nonNull(user.getBio()) && !"".equalsIgnoreCase(user.getBio())) 
	    {
	    	userModel.setBio(user.getBio());
	    }
	        
	    if (Objects.nonNull(user.getPhone()) && !"".equalsIgnoreCase(user.getPhone())) 
	    {
	    	userModel.setPhone(user.getPhone());
	    }
	        
	    if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) 
	    {
	    	userModel.setPassword(user.getPassword());
	    }
	    return userRepository.save(userModel);
	}

	@Override
	public User fetchUserDetails(String email, String password) 
	{
		User user = new User();
		userModel = new User();
		user = userRepository.findByEmailAndPassword(email,password);
		userModel.setBio(user.getBio());
		userModel.setName(user.getName());
		userModel.setEmail(user.getEmail());
		userModel.setPhone(user.getPhone());
		userModel.setPhoto(user.getPhoto());
		return userModel;
	}

	@Override
	public User updateUser(User user, String email) 
	{
		{
			userModel = new User(); 
			userModel = userRepository.findByEmail(email);
	 
	        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) 
	        {
	        	userModel.setName(user.getName());
	        }
	        
	        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) 
	        {
	        	userModel.setEmail(user.getEmail());
	        }
	        
	        if (Objects.nonNull(user.getPhoto()) && !"".equalsIgnoreCase(user.getPhoto())) 
	        {
	        	userModel.setPhoto(user.getPhoto());
	        }
	        
	        if (Objects.nonNull(user.getBio()) && !"".equalsIgnoreCase(user.getBio())) 
	        {
	        	userModel.setBio(user.getBio());
	        }
	        
	        if (Objects.nonNull(user.getPhone()) && !"".equalsIgnoreCase(user.getPhone())) 
	        {
	        	userModel.setPhone(user.getPhone());
	        }
	        
	        if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) 
	        {
	        	userModel.setPassword(user.getPassword());
	        }
	    
	        return userRepository.save(userModel);
		}
	}

	@Override
	public boolean CheckUserAlreadyExist(String email) 
	{
		if(userRepository.findByEmail(email)!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
