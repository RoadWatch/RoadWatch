package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.ForumComment;
import com.codeup.demo.Repos.ForumPost;
import com.codeup.demo.models.Comment;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import com.codeup.demo.services.ForumPostSvc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class FormPostController {

    private ForumPost forumPostDao;
    private ForumPostSvc postSvc;
    private ForumComment forumComment;

    public FormPostController(ForumPost forumPostDao, ForumPostSvc postSvc, ForumComment forumComment) {
        this.forumPostDao = forumPostDao;
        this.postSvc = postSvc;
        this.forumComment = forumComment;
    }

    //! Show forum view
    @GetMapping("/forum")
    public String showingForumView(Model model){
        if(postSvc.isUserLoggedIn()){
            User user = postSvc.getAuthUser();
            model.addAttribute("userId", user.getId());
            model.addAttribute("posts", postSvc.getReverseListOfPosts());
            model.addAttribute("post", new Post());
            return "forum/index";
        }
        return "redirect:/register";
    }

    //!POST A POST
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

    // Individual form view
    @GetMapping("/forum/{id}")
    public String show(Model model, @PathVariable String id){
        model.addAttribute(this.forumPostDao.getOne(Long.parseLong(id)));
        return "forum/view";
    }

    // Edit form GET
    @GetMapping("/forum/{id}/edit")
    public String edit(Model model, @PathVariable String id){
        model.addAttribute(this.forumPostDao.getOne(Long.parseLong(id)));
        return "forum/edit";
    }

    // Edit form POST
    @PostMapping("/forum/{id}/edit")
    public String pEdit(@PathVariable String id, @RequestParam String title, @RequestParam String body){
        User cUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = new Post(id, title, cUser.getId());
        forumPostDao.save(post);
        return "redirect:/forum/" + id;
    }

    // Create form GET
    @GetMapping("/forum/post")
    public String postF(){
        return "forum/create";
    }

    // Delete form
    @PostMapping("/forum/{id}/delete")
    public String del(@PathVariable String id){
        this.forumPostDao.deleteById(Long.parseLong(id));
        return "redirect:/forum";
    }

    // Adding a reply on a forum post
    @PostMapping("/forum/{id}/comment")
    public String comment(@PathVariable String id, @RequestParam String body){
        User cUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment = new Comment(body, cUser, this.forumPostDao.getOne(Long.parseLong(id)));
        this.forumComment.save(comment);
        return "redirect:/forum/" + id;
    }

    // Deleting a reply on a forum post
    @PostMapping("/forum/{id}/comment/{cid}")
    public String commentDelete(@PathVariable String id, @PathVariable String cid){
        User cUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.forumComment.deleteById(Long.parseLong(cid));
        return "redirect:/forum/" + id;
    }

}
