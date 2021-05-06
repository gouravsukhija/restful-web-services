package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the users")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	
	@Past
	@ApiModelProperty(notes="birthDate cannot be in future")
	private Date birthDate;
	
	@Size(min=2)
	@ApiModelProperty(notes="minimum size of name should be 2")
	private String name;
	
	
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
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

}
