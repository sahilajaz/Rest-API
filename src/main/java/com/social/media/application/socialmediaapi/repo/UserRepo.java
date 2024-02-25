package com.social.media.application.socialmediaapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.media.application.socialmediaapi.user.User;

public interface UserRepo extends JpaRepository<User , Integer>{

}
