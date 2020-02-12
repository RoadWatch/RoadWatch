package com.codeup.demo.services;

import com.codeup.demo.Repos.ForumComment;
import com.codeup.demo.models.Comment;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForumCommentSvc {
    private UserSvc userSvc;
    private ForumComment commentDao;

    public ForumCommentSvc(UserSvc userSvc, ForumComment commentDao) {
        this.userSvc = userSvc;
        this.commentDao = commentDao;
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

    public List<Comment> getReverseListOfComments(){
        List<Comment> all = commentDao.findAll();
        List<Comment> reverse = new ArrayList<>();
        for (int i = all.size()-1; i >= 0 ; i--) {
            reverse.add(all.get(i));
        }
        return reverse;
    }

}
