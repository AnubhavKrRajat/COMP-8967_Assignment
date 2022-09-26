package com.example.AuthenticationApp.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserDB")
public class User {
	
	@Id
	private String id;
	
	private String photo;
	private String name;
	private String bio;
	private String phone;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	public User(String id, String photo, String name, String bio, String phone,String email,String password) {
		super();
		this.id = id;
		this.photo = photo;
		this.name = name;
		this.bio = bio;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	
	public User() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}