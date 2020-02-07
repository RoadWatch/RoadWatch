package com.codeup.demo.Repos;

import com.codeup.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long>  {
    User findByUsername(String username);
}