package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static final Logger log = LoggerFactory.getLogger(UserDaoService.class);
	private static List<User> users=new ArrayList<>();
	private static int userCount=3;
	static {
		users.add(new User(1,new Date(),"Gourav"));
		users.add(new User(2,new Date(),"Amit"));
		users.add(new User(3,new Date(),"Sachin"));
		log.info(users.toString());
	}

	public List<User> findAll(){
		return users;
	}

	public User getById(int id) {
		for(User user:users) {
			if(user.getId()==id)
				return user;
		}

		return null;
	}

	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}

		users.add(user);

		return user;
	}

	public User deleteById(Integer id) {
		// TODO Auto-generated method stub
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().getId()==id)
				iterator.remove();
				return iterator.next();
		}
		
		return null;
	}
}
