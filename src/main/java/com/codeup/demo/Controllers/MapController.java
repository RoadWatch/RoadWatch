package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Report;
import com.codeup.demo.services.EnviromentSvc;
import com.codeup.demo.services.SearchSvc;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MapController {
    private EnviromentSvc enviromentSvc;
    private Reports reportsDao;
    private SearchSvc searchSvc;

    public MapController(EnviromentSvc enviromentSvc, Reports reportsDao, SearchSvc searchSvc) {
        this.enviromentSvc = enviromentSvc;
        this.reportsDao = reportsDao;
        this.searchSvc = searchSvc;
    }


    @GetMapping("/map/json")
    public @ResponseBody List<Report> mapJSON(){
        return reportsDao.findAll();
    }

    @GetMapping("/map")
    public String showMapPage(){
        return "map/index";
    }

//    @GetMapping("/map")
//    public String showMapPage(Model model){
//        List<Report> userReports = reportsDao.findAll();
//        if (userReports != null) {
//            model.addAttribute("userReports", userReports);
//        }
//        return "map/index";
//    }

    @PostMapping("/report/add")
    public String addReport(
            @RequestParam String query
    ){
        String token = enviromentSvc.getMapboxKey();
        searchSvc.executeSearch(query, token);
        return "redirect:/map";
    }

}
