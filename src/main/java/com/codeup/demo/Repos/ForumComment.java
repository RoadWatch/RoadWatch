package com.codeup.demo.Repos;

import com.codeup.demo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumComment extends JpaRepository<Comment, Long> {
}
