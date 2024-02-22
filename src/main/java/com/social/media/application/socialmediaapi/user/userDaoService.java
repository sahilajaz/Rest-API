package com.social.media.application.socialmediaapi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDaoService {
    private static List<User> users = new ArrayList<>();
    
    static {
    	users.add(new User(1 , "Adam" , LocalDate.now().minusYears(30)));
    	users.add(new User(2 , "eve" , LocalDate.now().minusYears(25)));
    	users.add(new User(3 , "Ethan" , LocalDate.now().minusYears(20)));
    }
    
    public List<User> findAll() {
    	return users;
    }
    
  public User findOne(int id) {
	  return users.stream().filter(user->user.getId().equals(id)).findFirst().get();
  }
    
}
