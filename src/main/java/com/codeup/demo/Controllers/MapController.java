package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Report;
import com.codeup.demo.services.EnviromentSvc;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MapController {
    private EnviromentSvc enviromentSvc;
    private Reports reportsDao;

    public MapController(EnviromentSvc enviromentSvc, Reports reportsDao) {
        this.enviromentSvc = enviromentSvc;
        this.reportsDao = reportsDao;
    }

    @GetMapping("/map")
    public String showMapPage(Model model){
        List<Report> userReports = reports.findAll();
        if (!(userReports.size() <= 0 || userReports == null)) {
            model.addAttribute("userReports", userReports);
        }
        return "map/index";
    }

    @PostMapping("/report/add")
    public String addReport(){
        return "redirect:/map";
    }

}
