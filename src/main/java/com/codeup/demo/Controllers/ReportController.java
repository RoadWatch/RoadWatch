package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.Repos.Users;
import com.codeup.demo.exception.UserException;
import com.codeup.demo.models.Endorsement;
import com.codeup.demo.models.Report;
import com.codeup.demo.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

    @GetMapping(path = "/report/all")
    public String index(Model model) {
        List<Report> reports = this.reportDoa.findAll();
        model.addAttribute("reports", reports);
        return "report/all";
    }

    @GetMapping(path = "/report/create")
    public String createGet(Model model) throws UserException {
        User cUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDoa.findById(cUser.getId()).orElseThrow(()-> new UserException()));
        model.addAttribute("report", new Report());
        return "report/create";
    }

    @PostMapping(path = "/report/{id}/edit")
    public String editReport(Model model, @PathVariable String id, @RequestParam String zipcode, @RequestParam String waterInches, @RequestParam String longitude, @RequestParam String latitude, @RequestParam String description){
        Report old = this.reportDoa.getOne(Long.parseLong(id));
        Report temp = new Report(Integer.parseInt(zipcode), Integer.parseInt(waterInches), longitude, latitude, description, old.getUser());
        reportDoa.save(temp);
        model.addAttribute("report", reportDoa.getOne(Long.parseLong(id)));
        return "report/view";
    }

    @PostMapping(path = "/report/{id}/delete")
    public String delete(@PathVariable String id){
        reportDoa.deleteById(Long.parseLong(id));
        return "redirect:/report";
    }

    @PostMapping(path = "/report/{id}/endorse")
    public String endorse(Model model, @PathVariable String id, @RequestParam String value, @RequestParam Date date) throws UserException {
        User cUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Endorsement endorsement = new Endorsement(Byte.parseByte(value), date, cUser, this.reportDoa.getOne(Long.parseLong(id)));
        this.endorsementsDoa.save(endorsement);
        return "redirect:/report/{id}";
    }

}
