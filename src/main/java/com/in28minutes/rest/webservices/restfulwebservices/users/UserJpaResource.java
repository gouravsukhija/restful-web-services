package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
public class UserJpaResource  {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping(path="/jpa/users")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping(path="/jpa/users/{id}")
	public Optional<User> findUser(@PathVariable Integer id) throws RuntimeException{
		
		Optional<User> user=userRepo.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		return user;
	}
	
	
	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post> retreiveAllPostsByUserId(@PathVariable Integer id) throws RuntimeException{
		
		Optional<User> user=userRepo.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		return user.get().getPosts();
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id) throws RuntimeException{
		
		userRepo.deleteById(id);
		
		
		//return user;
	}
	
	@PostMapping(path="/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPosts(@Valid @RequestBody Post post,@PathVariable Integer id){
		 Optional<User> user=userRepo.findById(id);
		 
		 if(!user.isPresent())
			 throw new UserNotFoundException("id-"+id);
		 
		 post.setUser(user.get());
		 
		 Post mypost=postRepo.save(post);
		 
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mypost.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		 User savedUser=userRepo.save(user);
		 
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
	}
}
