package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.exception.ReportException;
import com.codeup.demo.models.Endorsement;
import com.codeup.demo.models.Report;
import com.codeup.demo.models.User;
import com.codeup.demo.services.EndorsmentSvc;
import com.codeup.demo.services.UserSvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class EndorsmentController {
    private Endorsements endorsementDao;
    private EndorsmentSvc endorsmentSvc;
    private UserSvc userSvc;
    private Reports reportsDao;

    public EndorsmentController(Endorsements endorsementDao, EndorsmentSvc endorsmentSvc, UserSvc userSvc, Reports reportsDao) {
        this.endorsementDao = endorsementDao;
        this.endorsmentSvc = endorsmentSvc;
        this.userSvc = userSvc;
        this.reportsDao = reportsDao;
    }

    @PostMapping("/endorsements/{id}/{value}")
    public String addEndorsements(
            @PathVariable long id,
            @PathVariable int value
    ) throws ReportException {
        System.out.println("clicked");
        if(userSvc.isUserLoggedIn()){
            User user = userSvc.getAuthUser();
            Report report = reportsDao.findById(id)
                    .orElseThrow(()-> new ReportException());

            endorsmentSvc.updateEndorsementCount(report, value);
            Endorsement endorsement = new Endorsement(
                    (int)value,
                    user,
                    report
            );
            endorsementDao.save(endorsement);

            //! check what endorsments have 3 or more not happening
            endorsmentSvc.filterReports(id);
            return "redirect:/map";

        }
        return "redirect:/register";
    }





}
