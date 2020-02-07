package com.codeup.demo.Repos;

import com.codeup.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categories extends JpaRepository<Category, Long>  {
    Category findByName(String name);
}