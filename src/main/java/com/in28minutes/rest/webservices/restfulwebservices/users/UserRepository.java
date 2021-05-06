package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findAll();
	public Optional<User> findById(Integer id);
	
}
