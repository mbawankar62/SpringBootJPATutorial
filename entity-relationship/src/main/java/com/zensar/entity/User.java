package com.zensar.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyUser")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	private String userName;
	
	//1-1
	/**
	 * object references an unsaved transient instance - save the transient instance 
	 * before flushing : com.zensar.entity.User.laptop -> com.zensar.entity.Laptop
	 * (cascade = CascadeType.ALL)//if u not provided cascade then user data will not save
	 */
	//@OneToOne(cascade = CascadeType.ALL)
    //private Laptop laptop;
	
	//SELECT * FROM MY_USER;
	//ID  	USER_NAME  

	// this will create new table MY_USER_LAPTOP so we have 3 tables
	//MY_USER_LAPTOP contains column LAPTOP_ID  	USER_ID  
	//@OneToMany(cascade = CascadeType.ALL)
	//private List<Laptop> laptop;

	
	//but i dont want to create extra table "MY_USER_LAPTOP" and want to tell i have already mapped with 
	//laptop in laptop table(in laptop class i have already (private User user;)
	//means i ve already extra column in laptop table dont create table here 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
	private List<Laptop> laptop;
	
	public User() {
		super();
	}

	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	
	/* 1-1
	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}*/
	
}
