package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.exception.ReportException;
import com.codeup.demo.models.Endorsement;
import com.codeup.demo.models.Report;
import com.codeup.demo.models.User;
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
    private UserSvc userSvc;
    private Reports reportsDao;

    public EndorsmentController(Endorsements endorsementDao, UserSvc userSvc, Reports reportsDao) {
        this.endorsementDao = endorsementDao;
        this.userSvc = userSvc;
        this.reportsDao = reportsDao;
    }

    @PostMapping("/endorsements/{id}/{value}")
    public String addEndorsements(
            @PathVariable long id,
            @PathVariable int value
    ) throws ReportException {
        if(userSvc.isUserLoggedIn()){
            User user = userSvc.getAuthUser();
            Report report = reportsDao.findById(id)
                    .orElseThrow(()-> new ReportException());
            Endorsement endorsement = new Endorsement(
                    (int)value,
                    user,
                    report
            );
            endorsementDao.save(endorsement);

            //! check what endorsments have 3 or more not happening
            filterReports(id);
            return "redirect:/map";

        }
        return "redirect:/register";
    }

    private void filterReports(long id) throws ReportException {
        int negativeCount = 0;
       Report report = reportsDao.findById(id)
               .orElseThrow(()-> new ReportException());
       if(report.getEndorsements() != null){
           List<Endorsement> endorsements = report.getEndorsements();
           for (Endorsement endorsement : endorsements) {
               if(endorsement.getValue() == 2) negativeCount +=1 ;
           }
       }
       if(negativeCount >= 3) {
           reportsDao.delete(report);
           System.out.println("Report deleted");
       }
       else System.out.println("Report still active");

    }



}
