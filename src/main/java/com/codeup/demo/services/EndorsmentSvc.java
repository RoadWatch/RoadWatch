package com.codeup.demo.services;

import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.exception.ReportException;
import com.codeup.demo.models.Endorsement;
import com.codeup.demo.models.Report;
import org.springframework.stereotype.Service;

import java.util.List;

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
            int positiveCount = report.getPositiveEndorsementCount();
            positiveCount++;
            report.setPositiveEndorsementCount(positiveCount);
        } else {
            int negativeCount = report.getNegativeEndorsementCount();
            negativeCount++;
            report.setNegativeEndorsementCount(negativeCount);
        }
    }


    public void filterReports(long id) throws ReportException {
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
//            reportsDao.delete(report);
            System.out.println("Report #" + report.getId() + " invalidated");
        }
        else System.out.println("Report still active");

    }
}
