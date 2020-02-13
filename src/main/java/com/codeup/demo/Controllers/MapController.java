package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Categories;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Category;
import com.codeup.demo.models.Report;
import com.codeup.demo.models.User;
import com.codeup.demo.services.EnviromentSvc;
import com.codeup.demo.services.GeocodeSvc;
import com.codeup.demo.services.UserSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class MapController {
    private EnviromentSvc enviromentSvc;
    private Reports reportsDao;
    private GeocodeSvc geocodeSvc;
    private UserSvc userSvc;
    private Categories categoriesDao;

    public MapController(EnviromentSvc enviromentSvc, Reports reportsDao, GeocodeSvc geocodeSvc, UserSvc userSvc, Categories categoriesDao) {
        this.enviromentSvc = enviromentSvc;
        this.reportsDao = reportsDao;
        this.geocodeSvc = geocodeSvc;
        this.userSvc = userSvc;
        this.categoriesDao = categoriesDao;
    }


//    public MapController(Reports reportsDao) {
//        this.reportsDao = reportsDao;
//    }

    @GetMapping("/map")
    public String showMapPage(Model model){

        List<Category> categories = categoriesDao.findAll();
        model.addAttribute("categories", categories);

        List<Report> userReports = reportsDao.findAll();
        if (userReports != null) {
            model.addAttribute("userReports", userReports);
        }

        return "map/index";
    }

    @PostMapping("/report/add")
    public String addReport(
            @RequestParam String query,
            @RequestParam int waterLevel,
            @RequestParam String description,
            @RequestParam String[] primitiveCategories
    ){
        if(userSvc.isUserLoggedIn()){
            User user = userSvc.getAuthUser();
            Report report = new Report(waterLevel, description);

            //add categories to report
            List<String> categoriesAsList = Arrays.asList(primitiveCategories);
            List<Category> allCategories = categoriesDao.findAll();
            for (int i = 0; i < allCategories.size(); i++) {
                String name = allCategories.get(i).getName();
                if(categoriesAsList.contains(name)){
                    report.addCategory(allCategories.get(i));
                }
            }

            String token = enviromentSvc.getMapboxKey();
            geocodeSvc.executeSearch(query, token, user, report);

            return "redirect:/map";
        }
        return "redirect:/login";

    }

}

