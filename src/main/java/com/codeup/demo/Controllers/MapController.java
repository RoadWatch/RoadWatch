package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Report;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class MapController {

    private Reports reports;

    public MapController(Reports reports) {
        this.reports = reports;
    }

    @GetMapping("/map")
    public String showMapPage(Model model){
        List<Report> userReports = reports.findAll();
        if (!(userReports.size() <= 0 || userReports == null)) {
            model.addAttribute("userReports", userReports);
        }
        return "map/index";
    }

}
