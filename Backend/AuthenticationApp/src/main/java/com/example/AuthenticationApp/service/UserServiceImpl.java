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
	

	@Override
	public User saveUser(User user) 
	{
		return userRepository.save(user);
	}

	@Override
	public User fetchUserDetails(String email, String password) 
	{
		return userRepository.findByEmailAndPassword(email,password);
	}

	@Override
	public User updateUser(User user, String userId) 
	{
		{
			 
	        User userInfo = userRepository.findById(userId).get();
	 
	        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) 
	        {
	            userInfo.setName(user.getName());
	        }
	        
	        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) 
	        {
	            userInfo.setEmail(user.getEmail());
	        }
	        
	        if (Objects.nonNull(user.getPhoto()) && !"".equalsIgnoreCase(user.getPhoto())) 
	        {
	            userInfo.setPhoto(user.getPhoto());
	        }
	        
	        if (Objects.nonNull(user.getBio()) && !"".equalsIgnoreCase(user.getBio())) 
	        {
	            userInfo.setBio(user.getBio());
	        }
	        
	        if (Objects.nonNull(user.getPhone()) && !"".equalsIgnoreCase(user.getPhone())) 
	        {
	            userInfo.setPhone(user.getPhone());
	        }
	        
	        if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) 
	        {
	            userInfo.setPassword(user.getPassword());
	        }
	    
	        return userRepository.save(userInfo);
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
