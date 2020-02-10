package com.codeup.demo.services;

import com.codeup.demo.Repos.ForumPost;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ForumPostSvc {
    private ForumPost postDao;
    private UserSvc userSvc;

    public ForumPostSvc(ForumPost postDao, UserSvc userSvc) {
        this.postDao = postDao;
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

    public List<Post> getReverseListOfPosts(){
        List<Post> all = postDao.findAll();
        List<Post> reverse = new ArrayList<>();
        for (int i = all.size()-1; i >= 0 ; i--) {
            reverse.add(all.get(i));
        }
        return reverse;
    }
}
