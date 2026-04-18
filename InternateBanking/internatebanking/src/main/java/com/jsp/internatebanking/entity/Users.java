package com.jsp.internatebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private double balance;
	private String salt;
	@Lob
	@Column(name = "profile_image")
	private byte[] profileImage;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	 

	public Users(String name, String email, String password, double balance) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public byte[] getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	
	
	
	
	
	
}
