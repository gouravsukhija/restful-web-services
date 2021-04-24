package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.util.Date;

public class User {
	
	private Integer id;
	private Date birthDate;
	public User(Integer id, Date birthDate, String name) {
		// TODO Auto-generated constructor stub
		
		this.birthDate=birthDate;
		this.id=id;
		this.name=name;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", birthDate=" + birthDate + ", name=" + name + "]";
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;

}
