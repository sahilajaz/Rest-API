package com.social.media.application.socialmediaapi.user;

import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.media.application.socialmediaapi.post.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
	
	 public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	protected User() {
		 
	 }
	 
	 @Id
	 @GeneratedValue
     private Integer id;
	@Size(min = 2)
     private String name;
     @Past
     private LocalDate birthDate;
     
     @OneToMany(mappedBy="user")
     @JsonIgnore
     private List<Post> post;
     
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	
     
     
}	
