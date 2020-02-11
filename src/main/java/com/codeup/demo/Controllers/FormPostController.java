package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.ForumPost;
import com.codeup.demo.exception.PostException;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import com.codeup.demo.services.ForumPostSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class FormPostController {

    private ForumPost forumPostDao;
    private ForumPostSvc postSvc;


    public FormPostController(ForumPost forumPostDao, ForumPostSvc postSvc) {
        this.forumPostDao = forumPostDao;
        this.postSvc = postSvc;
    }

    //! Show forum view
    @GetMapping("/forum")
    public String showingForumView(Model model){
        if(postSvc.isUserLoggedIn()){
            User user = postSvc.getAuthUser();
            model.addAttribute("userId", user.getId());
            model.addAttribute("posts", postSvc.getReverseListOfPosts());
            model.addAttribute("post", new Post());
            model.addAttribute("editPost", new Post());
            return "forum/index";
        }
        return "redirect:/register";
    }

    //!CREATE A POST
    @PostMapping("/forum/post")
    public String createAPost(
            @ModelAttribute Post post
    ){
        if(postSvc.isUserLoggedIn()){
            User user = postSvc.getAuthUser();
            post.setUser(user);
            forumPostDao.save(post);
            return "redirect:/forum";
        }
        return "redirect:/login";
    }

    //!EDIT A POST
    @PostMapping("/forum/post/edit/{id}")
    public String editPost(
            @RequestParam String title,
            @RequestParam String body,
            @PathVariable long id
    ) throws PostException {
        if(postSvc.isUserLoggedIn()){
            User user = postSvc.getAuthUser();
            Post currentPost = forumPostDao.findById(id)
                    .orElseThrow(()-> new PostException());
            if(currentPost.getUser().getId() == user.getId()){
                currentPost.setTitle(title);
                currentPost.setBody(body);
                forumPostDao.save(currentPost);
                return "redirect:/forum";
            }
        }
        return "redirect:/map";

    }


}
