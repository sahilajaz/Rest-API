package com.social.media.application.socialmediaapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.media.application.socialmediaapi.post.Post;

public interface PostRepo extends JpaRepository<Post , Integer>{

}
