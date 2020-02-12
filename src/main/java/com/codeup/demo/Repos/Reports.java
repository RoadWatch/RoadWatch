package com.codeup.demo.Repos;

import com.codeup.demo.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reports extends JpaRepository<Report, Long> {

}