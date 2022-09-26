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
	
	User saveUser;
	
	@Override
	public User saveUser(User user) 
	{
		if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) 
	    {
			saveUser.setName(user.getName());
	    }
	        
	    if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) 
	    {
	    	saveUser.setEmail(user.getEmail());
	    }
	        
	    if (Objects.nonNull(user.getPhoto()) && !"".equalsIgnoreCase(user.getPhoto())) 
	    {
	    	saveUser.setPhoto(user.getPhoto());
	    }
	        
	    if (Objects.nonNull(user.getBio()) && !"".equalsIgnoreCase(user.getBio())) 
	    {
	      	saveUser.setBio(user.getBio());
	    }
	        
	    if (Objects.nonNull(user.getPhone()) && !"".equalsIgnoreCase(user.getPhone())) 
	    {
	     	saveUser.setPhone(user.getPhone());
	    }
	        
	    if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) 
	    {
	     	saveUser.setPassword(user.getPassword());
	    }
	    return userRepository.save(saveUser);
	}

	@Override
	public User fetchUserDetails(String email, String password) 
	{
		return userRepository.findByEmailAndPassword(email,password);
	}

	@Override
	public User updateUser(User user, String email) 
	{
		{
			 
	        saveUser = userRepository.findByEmail(email);
	 
	        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) 
	        {
	        	saveUser.setName(user.getName());
	        }
	        
	        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) 
	        {
	        	saveUser.setEmail(user.getEmail());
	        }
	        
	        if (Objects.nonNull(user.getPhoto()) && !"".equalsIgnoreCase(user.getPhoto())) 
	        {
	        	saveUser.setPhoto(user.getPhoto());
	        }
	        
	        if (Objects.nonNull(user.getBio()) && !"".equalsIgnoreCase(user.getBio())) 
	        {
	        	saveUser.setBio(user.getBio());
	        }
	        
	        if (Objects.nonNull(user.getPhone()) && !"".equalsIgnoreCase(user.getPhone())) 
	        {
	        	saveUser.setPhone(user.getPhone());
	        }
	        
	        if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) 
	        {
	        	saveUser.setPassword(user.getPassword());
	        }
	    
	        return userRepository.save(saveUser);
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
