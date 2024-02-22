package com.social.media.application.socialmediaapi.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userResource {
	private userDaoService daoService;
	
	public userResource(userDaoService daoService) {
		this.daoService = daoService;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAll() {
	   return daoService.findAll();	 
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUsre(@PathVariable int id) {
		return daoService.findOne(id);
	}
}
