package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Users;
import com.codeup.demo.exception.UserException;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import com.codeup.demo.services.UserSvc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private Users userDao;
    private PasswordEncoder passwordEncoder;
    private UserSvc userSvc;

    public UserController(Users userDao, PasswordEncoder passwordEncoder, UserSvc userSvc) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.userSvc = userSvc;
    }

    //! USER PROFILE, get by id
    @GetMapping("/user/profile")
    public String showUserProfile(
            Model model
    ) throws UserException {
        System.out.println("here: "+userSvc.isUserLoggedIn());
        if(userSvc.isUserLoggedIn()){
            User user = userDao.getOne(userSvc.getAuthUser().getId());
            model.addAttribute("user", user);
            return "user/profile";
        }
        else return "redirect:/register";
    }

    //! CREATE USER
    @GetMapping("/register")
    public String showCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/register")
    public String createUser(
            @ModelAttribute User user
    ) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/";
    }

    //! EDIT USER PROFILE

    @GetMapping("/user/{id}/edit")
    public String editUserInfo(Model model, @PathVariable long id) {
        model.addAttribute("user", new User());
        return "/user/{id}/edit";
    }

    @PostMapping("/user/{id}/edit")
    public String editUserProfile(
            @PathVariable long id,
            @ModelAttribute User user
    ) {
        if (userSvc.isUserLoggedIn()) {
            System.out.println(userSvc.getAuthUser().getPassword());
            System.out.println(user.getId());
            userDao.save(user);
            return "redirect:/user/profile";
        }
        return "redirect:/";
    }

    //! DELETE USER
    @PostMapping("/user/{id}/delete")
    public String deleteUser(
            @PathVariable long id,
            @ModelAttribute User user,
            HttpSession session
            ) {
        if (userSvc.isUserLoggedIn()) {
            userDao.deleteById(id);
            session.invalidate();
            return "redirect:/register";
        }

        return "redirect:/";
    }
}