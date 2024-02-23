package com.social.media.application.socialmediaapi.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;

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
	public EntityModel<User> retrieveUsre(@PathVariable int id) {
		User user = Service.findOne(id);
		if(user == null) {
			throw new userNotFoundException("id:"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAll());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = Service.save(user);
		URI uriComponents = UriComponentsBuilder.newInstance().path("users/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uriComponents).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteById(@PathVariable int id) {
		Service.deleteUser(id);
	}
}
