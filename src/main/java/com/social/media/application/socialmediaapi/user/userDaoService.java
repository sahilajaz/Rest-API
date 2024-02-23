package com.social.media.application.socialmediaapi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDaoService {
    private static List<User> users = new ArrayList<>();
    public static int userCount = 0;
    
    static {
    	users.add(new User(++userCount , "Adam" , LocalDate.now().minusYears(30)));
    	users.add(new User(++userCount , "eve" , LocalDate.now().minusYears(25)));
    	users.add(new User(++userCount , "Ethan" , LocalDate.now().minusYears(20)));
    }
    
    public List<User> findAll() {
    	return users;
    }
    
    public User save(User user) {
    	user.setId(++userCount);
    	users.add(user);
    	return 	user;
    }
    
  public User findOne(int id) {
	  return users.stream().filter(user->user.getId().equals(id)).findFirst().orElse(null);
  }
  
  public void deleteUser(int id) {
	 User removeUser = users.stream().filter(user-> user.getId().equals(id)).findFirst().get();
	 users.remove(removeUser);
  }
    
}
