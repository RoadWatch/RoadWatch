package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.ForumPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormPostController {

    private ForumPost forumPostDao;

    public FormPostController(ForumPost forumPostDao) {
        this.forumPostDao = forumPostDao;
    }

    //! Show forum view
//    @GetMapping("/forum")
//    public String showi
}
