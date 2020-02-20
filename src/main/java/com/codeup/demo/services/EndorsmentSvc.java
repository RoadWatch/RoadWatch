package com.codeup.demo.services;

import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Report;
import org.springframework.stereotype.Service;

@Service
public class EndorsmentSvc {
    private Reports reportsDao;
    private Endorsements endorsementsDao;

    public EndorsmentSvc(Reports reportsDao, Endorsements endorsementsDao) {
        this.reportsDao = reportsDao;
        this.endorsementsDao = endorsementsDao;
    }

    public void updateEndorsementCount(Report report, int value){
        if(value == 1){
            int postitveCount = report.getPositiveEndorsementCount();
            report.setPositiveEndorsementCount(postitveCount++);
        } else {
            int negativeCount = report.getNegativeEndorsementCount();
            report.setNegativeEndorsementCount(negativeCount++);
        }
    }
}
