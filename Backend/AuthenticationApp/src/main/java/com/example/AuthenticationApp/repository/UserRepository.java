package com.example.AuthenticationApp.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.AuthenticationApp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	Optional<User> findByResetToken(String resetToken);
	
	

}
