package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Users;
import com.codeup.demo.exception.UserException;
import com.codeup.demo.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private Users userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(Users userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    //! USER PROFILE, get by id
    @GetMapping("/user/{id}")
    public String showUserProfile(
            @PathVariable long id,
            Model model
    ) throws UserException {
        System.out.println("ID: "+id);
        User user = userDao.findById(id)
                .orElseThrow(()-> new UserException());
        System.out.println(user.getFirstName());
        model.addAttribute("user", user);
        return "user/profile";
    }
    //! CREATE USER
    @GetMapping("/register")
    public String showCreateUser(Model model){
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
        return "redirect:/login";
    }

    //! EDIT USER PROFILE
    @GetMapping("/user/{id}/edit")
    public String showEditUserPage(
            @PathVariable long id,
            Model model
    ) throws UserException {
        User user = userDao.findById(id)
                .orElseThrow(()-> new UserException());
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/user/{id}/edit")
    public String editUserProfile(
            @PathVariable long id,
            @ModelAttribute(name = "") User user
    ){
        userDao.save(user);
        return "redirect:/user/"+user.getId();
    }

    //! DELETE USER
    @PostMapping("/user/{id}/delete")
    public String deleteUser(
            @PathVariable long id
    ) throws UserException {
        User user = userDao.findById(id)
                .orElseThrow(()-> new UserException());

        return "redirect:/login";

    }


}
