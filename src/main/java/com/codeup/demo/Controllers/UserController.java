package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Users;
import com.codeup.demo.exception.UserException;
import com.codeup.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private Users userDao;

    public UserController(Users userDao) {
        this.userDao = userDao;
    }

    //! USER PROFILE
    @GetMapping("/user/{id}")
    public String showUserProfile(
            @PathVariable long id,
            Model model
    ) throws UserException {
        User user = userDao.findById(id)
                .orElseThrow(()-> new UserException());
        model.addAttribute("user", user);
        return "user/profile";
    }



}
