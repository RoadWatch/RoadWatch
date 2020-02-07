package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.Repos.Users;
import com.codeup.demo.models.Report;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class ReportController {
    private final Reports reportDoa;

    private final Users usersDoa;

    private final Endorsements endorsementsDoa;

    public ReportController(Reports reportDoa, Users usersDoa, Endorsements endorsementsDoa) {
        this.reportDoa = reportDoa;
        this.usersDoa = usersDoa;
        this.endorsementsDoa = endorsementsDoa;
    }

    @GetMapping(path = "/INSERT PATH")
    public String index(Model model) {
        List<Report> reports = this.reportDoa.findAll();
        model.addAttribute("reports", reports);
        return "INSERT VIEW";
    }

//    @PostMapping(path = "/posts/{id}/edit")
//    public String editPost(@PathVariable String id, Model model, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
//        Post old = pDoa.getOne(Long.parseLong(id));
//        Post temp = new Post(old.getId(), title, body, old.getUser());
//        pDoa.save(temp);
//        model.addAttribute("post", pDoa.getOne(Long.parseLong(id)));
//        return "posts/post-view";
//    }
}
