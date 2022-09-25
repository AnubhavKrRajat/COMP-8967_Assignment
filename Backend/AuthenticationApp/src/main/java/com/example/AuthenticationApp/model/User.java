package com.example.AuthenticationApp.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "UserDB")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	private String Id;
	
	private String photo;
	private String name;
	private String bio;
	private String phone;
	private String email;
	private String password;

public User(String Id, String photo, String name, String bio, String phone, String email, String password )
{
	this.Id = Id;
	this.photo = photo;
	this.name = name;
	this.bio = bio;
	this.email = email;
	this.password = password;
	this.phone = phone;
}

}