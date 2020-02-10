package com.codeup.demo.Repos;

import com.codeup.demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumPost extends JpaRepository<Post, Long> {

}
