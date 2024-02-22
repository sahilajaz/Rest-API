package com.social.media.application.socialmediaapi.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class userResource {
	private userDaoService Service;
	
	public userResource(userDaoService daoService) {
		this.Service = daoService;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAll() {
	   return Service.findAll();
	   
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUsre(@PathVariable int id) {
		User user = Service.findOne(id);
		if(user == null) {
			throw new userNotFoundException("id:"+id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = Service.save(user);
		URI uriComponents = UriComponentsBuilder.newInstance().path("users/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uriComponents).build();
	}
}
