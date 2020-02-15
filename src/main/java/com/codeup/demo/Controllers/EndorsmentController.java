package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Users;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Controller
public class EndorsmentController {
    private Endorsements endorsementDao;
    private Users userDao;

    public EndorsmentController(Endorsements endorsementDao, Users userDao) {
        this.endorsementDao = endorsementDao;
        this.userDao = userDao;
    }


    @PostMapping("/endorsement")
    public String addEndorsment(
            @RequestParam long id,
            @RequestParam int value
    ){
        System.out.println("value: "+value);
        System.out.println("id: "+ id);
        return "redirect:/map";
    }
}
