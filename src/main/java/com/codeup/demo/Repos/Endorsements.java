package com.codeup.demo.Repos;

import com.codeup.demo.models.Endorsement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Endorsements extends JpaRepository<Endorsement, Long>  {

}