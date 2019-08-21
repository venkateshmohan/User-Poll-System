package com.company2.socialpolling;

import java.sql.Date;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "User")
public class User {
	
	
	public User() {
		
	}
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		
	}

	/**
	 * Unique identifier. This value is auto incremented.
	 */
	@Id
	@NonNull
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/* One-to-One mapping with User Id in UserPoll entity */
	/*
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "user_id") private UserPoll userpoll;
	 */
	

	
	@OneToMany(
	        mappedBy = "user", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	 private List<UserPoll> userpolls = new ArrayList<>();

	/**
	 * Username of the user.
	 */
	private String userName;

	/**
	 * users fullname
	 */
	private String fullname;

	/**
	 * users email
	 */
	private String email;

	/**
	 * Password of the user account.
	 */
	@NonNull
	private String password;
	
	/**
	 * Temporary password of the user account.
	 */
	private String tempPWD;
	
	/**
	 * active status of user
	 */
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active = true;

	/**
	 * users phone number
	 */
	@Column(name = "phone_number")
	private String phone_number;

	/**
	 * users city
	 */
	@Column(name = "city")
	private String city;
	

	@Column(name = "isAdmin")
	private int isAdmin;


	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	/**
	 * getter method for city
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 * setter method for city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return phone number
	 * getter method for phone number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number
	 * setter method for phone number
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * getter method for id.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * 
	 * setter method for id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter method for username.
	 * 
	 * @return username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param username 
	 * setter method for username.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return fullname
	 * getter method for full name
	 */
	public String getFullname() {
		return fullname;
	}

	public List<UserPoll> getUserpolls() {
		return userpolls;
	}
	public void setUserpolls(List<UserPoll> userpolls) {
		this.userpolls = userpolls;
	}
	/**
	 * @param fullname
	 * setter method for fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return email
	 * getter method for email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 * setter method for url
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return active
	 * getter method for active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 * setter method for active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * getter method for password 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password setter method for password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

	/**
	 * getter method for temporary password 
	 * @return temporary password
	 */
	public String getTempPassword() {
		return tempPWD;
	}

	/**
	 * @param password setter method for password
	 */
	public void setTempPassword(String tempPWD) {
		this.tempPWD = tempPWD;
	}

}
