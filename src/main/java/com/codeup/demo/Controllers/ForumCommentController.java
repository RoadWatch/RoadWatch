package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.ForumComment;
import com.codeup.demo.Repos.ForumPost;
import com.codeup.demo.exception.PostException;
import com.codeup.demo.models.Comment;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import com.codeup.demo.services.ForumCommentSvc;
import com.codeup.demo.services.UserSvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ForumCommentController {
    private ForumComment forumCommentDao;
    private ForumCommentSvc forumCommentSvc;
    private ForumPost forumPostDao;

    public ForumCommentController(ForumComment forumCommentDao, ForumCommentSvc forumCommentSvc, ForumPost forumPostDao) {
        this.forumCommentDao = forumCommentDao;
        this.forumCommentSvc = forumCommentSvc;
        this.forumPostDao = forumPostDao;
    }

    //!CREATE COMMENT
    @PostMapping("/forum/comment/{id}")
    public String postComment(
            @ModelAttribute Comment comment,
            @PathVariable long id
            ) throws PostException {
        comment.setIdToNull();
        if(forumCommentSvc.isUserLoggedIn()){
            User user = forumCommentSvc.getAuthUser();
            Post post = forumPostDao.findById(id)
                    .orElseThrow(()-> new PostException());
            comment.setUser(user);
            comment.setPost(post);
            forumCommentDao.save(comment);
            post.addComment(comment);
            return "redirect:/forum";

        }
        return "redirect:/";
    }

    //! DELETE COMMENT
    @PostMapping("/comment/delete/{id}")
    public String deleteComment(
            @PathVariable long id
    ) throws PostException {
        if(forumCommentSvc.isUserLoggedIn()){
            Comment comment = forumCommentDao.findById(id)
                    .orElseThrow(()-> new PostException());
            forumCommentDao.delete(comment);
            return "redirect:/forum";
        }
        return "redirect:/";
    }

}
