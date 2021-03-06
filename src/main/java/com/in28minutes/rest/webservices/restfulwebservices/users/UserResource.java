package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource  {

	@Autowired
	private UserDaoService userDao;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User findUser(@PathVariable Integer id) throws RuntimeException{
		
		User user=userDao.getById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		return user;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable Integer id) throws RuntimeException{
		
		User user=userDao.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		//return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		 User savedUser=userDao.save(user);
		 
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
	}
}
