package com.social.media.application.socialmediaapi.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.social.media.application.socialmediaapi.post.Post;
import com.social.media.application.socialmediaapi.repo.PostRepo;
import com.social.media.application.socialmediaapi.repo.UserRepo;

import jakarta.validation.Valid;

@RestController
public class userResource {
	private UserRepo  repository;
	private PostRepo postRepository;
	
	public userResource(UserRepo  repository ,PostRepo postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAll() {
	   return repository.findAll();
	   
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<Optional<User>> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new userNotFoundException("id:"+id);
		}
		
		EntityModel<Optional<User>> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAll());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI uriComponents = UriComponentsBuilder.newInstance().path("users/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uriComponents).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteById(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@GetMapping("users/jpa/{id}")
	public List<Post> retrievePostForAUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new userNotFoundException("id:"+id);
		}
		
		return user.get().getPost();
	}
	
	@GetMapping("users/jpa/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id , @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new userNotFoundException("id:"+id);
		}
		
		post.setUser(user.get());
		Post savedUser = postRepository.save(post);
		URI uriComponents = UriComponentsBuilder.newInstance().path("users/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uriComponents).build();
	}
	
	
}
