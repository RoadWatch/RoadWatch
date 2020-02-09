package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.ForumPost;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import com.codeup.demo.services.ForumPostSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
            Post post = new Post();
            post.setUser(user);
            model.addAttribute("post", post);
            return "forum/index";
        }
        return "redirect:/register";
    }
}
