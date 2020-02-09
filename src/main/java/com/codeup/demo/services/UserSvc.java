package com.codeup.demo.services;

import com.codeup.demo.Repos.Users;
import com.codeup.demo.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {
    private Users userDao;

    public UserSvc(Users userDao) {
        this.userDao = userDao;
    }

    //! check if there is a user logged in
    public boolean isUserLoggedIn(){
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }
    //! check if logged in user matches param
    public boolean checkIfCurrentUserMatchesParam(
            User authUser,
            User paramUser
    ){
        if(authUser.getId() == paramUser.getId()) return true;
        else return false;
    }

    //! get current user
    public User getAuthUser(){
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
