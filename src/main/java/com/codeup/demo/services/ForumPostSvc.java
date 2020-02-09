package com.codeup.demo.services;

import com.codeup.demo.Repos.ForumPost;
import com.codeup.demo.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ForumPostSvc {

   private UserSvc userSvc;

    public ForumPostSvc(UserSvc userSvc) {
        this.userSvc = userSvc;
    }


    public boolean isUserLoggedIn(){
        return userSvc.isUserLoggedIn();
    }


    public User getAuthUser(){
        return userSvc.getAuthUser();
    }

    public boolean checkIfCurrentUserMatchesParam(
            User authUser,
            User paramUser
    ){
        return userSvc.checkIfCurrentUserMatchesParam(authUser,paramUser);
    }
}
