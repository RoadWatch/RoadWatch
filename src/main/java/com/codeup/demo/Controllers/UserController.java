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

    @PostMapping("/user/{id}/edit")
    public String editUserProfile(
            @PathVariable long id,
            Model model,
            @RequestParam (name = "firstName") String firstName,
            @RequestParam (name = "lastName") String lastName,
            @RequestParam (name = "username") String username,
            @RequestParam (name = "email") String email,
            @ModelAttribute(name = "") User user
    ){
        if(userSvc.isUserLoggedIn()){
        User user1 = userSvc.getAuthUser();
        user1.setFirstName("firstName");
        user1.setLastName("LastName");
        user1.setUsername("username");
        user1.setEmail("email");
        userDao.save(user1);
        return "redirect:/user/"+user.getId();
        }
        return "redirect:/login";
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
