package com.example.AuthenticationApp.service;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AuthenticationApp.model.User;
import com.example.AuthenticationApp.repository.UserRepository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

@Service
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	UserRepository userRepository;
	
	User userModel;
	
	@Override
	@Transactional
	public User saveUser(User user) 
	{
		userModel = new User();
		userModel.setId(user.getId());
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
	    if (Objects.nonNull(user.getResetToken()) && !"".equalsIgnoreCase(user.getResetToken())) 
	    {
	    	userModel.setResetToken(user.getResetToken());
	    }
	    return userRepository.save(userModel);
	}

	@Override
	@Transactional
	public User fetchUserDetails(String email, String password) 
	{
		User user = new User();
		user = userRepository.findByEmailAndPassword(email,password);
		if(Objects.isNull(user))
		{
			return user;
		}
		else
		{
			userModel = new User();
			userModel.setBio(user.getBio());
			userModel.setName(user.getName());
			userModel.setEmail(user.getEmail());
			userModel.setPhone(user.getPhone());
			userModel.setPhoto(user.getPhoto());
			userModel.setId(user.getId());
			userModel.setResetToken(user.getResetToken());
		}
		
		return userModel;
	}
	
	@Transactional
	public User findUserByEmail(String email) 
	{
		User user = new User();
		user = userRepository.findByEmail(email);
		if(Objects.isNull(user))
		{
			return user;
		}
		else
		{
			userModel = new User();
			userModel.setBio(user.getBio());
			userModel.setName(user.getName());
			userModel.setEmail(user.getEmail());
			userModel.setPhone(user.getPhone());
			userModel.setPhoto(user.getPhoto());
			userModel.setId(user.getId());
			userModel.setResetToken(user.getResetToken());
		}
		
		return userModel;
	}

	@Override
	@Transactional
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
	        if (Objects.nonNull(user.getResetToken()) && !"".equalsIgnoreCase(user.getResetToken())) 
		    {
		    	userModel.setResetToken(user.getResetToken());
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
	
	public User findUserByResetToken(String resetToken) {
		return userRepository.findByResetToken(resetToken);
	}
}
