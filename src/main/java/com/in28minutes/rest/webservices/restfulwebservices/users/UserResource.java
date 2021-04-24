package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDao;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User findUser(@PathVariable Integer id){
		return userDao.getById(id);
	}
	
	@PostMapping(path="/users")
	public void createUser(@RequestBody User user){
		 userDao.save(user);
	}
}
