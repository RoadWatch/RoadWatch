package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Categories;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Category;
import com.codeup.demo.models.Report;
import com.codeup.demo.models.User;
import com.codeup.demo.services.EnviromentSvc;
import com.codeup.demo.services.GeocodeSvc;
import com.codeup.demo.services.ReportSvc;
import com.codeup.demo.services.UserSvc;
import okhttp3.MultipartBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class MapController {
    private EnviromentSvc enviromentSvc;
    private Reports reportsDao;
    private GeocodeSvc geocodeSvc;
    private UserSvc userSvc;
    private Categories categoriesDao;
    private ReportSvc reportSvc;

    public MapController(EnviromentSvc enviromentSvc, Reports reportsDao, GeocodeSvc geocodeSvc, UserSvc userSvc, Categories categoriesDao, ReportSvc reportSvc) {
        this.enviromentSvc = enviromentSvc;
        this.reportsDao = reportsDao;
        this.geocodeSvc = geocodeSvc;
        this.userSvc = userSvc;
        this.categoriesDao = categoriesDao;
        this.reportSvc = reportSvc;
    }

    // DO NOT REMOVE!!! We need this for the user-submitted reports to show on the map!
    @GetMapping("/map/json")
    public @ResponseBody List<Report> mapJSON(){
        int daysOld = 2; /* expiration day on reports */
        int downVoteMax = 2; /* amount of times a report has to be down-voted before it is no longer shown */
        List<Report> all = reportsDao.findAll();
        List<Report> temp = new ArrayList<>();
        Date date = new Date();
        long day = 1000 * 60 * 60 * 24;
        Date expire = new Date(date.getTime() - (daysOld * day));
        // Filters reports out of what is shown to users
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getDateEntered().compareTo(expire) > 0 || all.get(i).getRating() > downVoteMax){
                temp.add(all.get(i));
            }
        }
        return temp;
    }

    @GetMapping("/map")
    public String showMapPage(Model model){
        List<Category> categories = categoriesDao.findAll();
        List<Report> reports = reportsDao.findAll();

        for (Report report : reports) {
            System.out.println(report.getDateEntered());
        }

        model.addAttribute("categories", categories);
        List<Report> activeReports = new ArrayList<>();
        model.addAttribute("categories", categories);
        for (Report report : reports) {
            Date date = new Date();
            long day = 1000 * 60 * 60 * 24;
            Date expire = new Date(date.getTime() - (2 * day));
            if(report.getDateEntered().compareTo(expire) <= 0){
                reportsDao.delete(report);
                System.out.println("report deleted");
            }
            else activeReports.add(report);
        }

        model.addAttribute("reports", activeReports);
        return "map/index";
    }

    @PostMapping("/report/add")
    public String addReport(
            @RequestParam String query,
            @RequestParam int waterLevel,
            @RequestParam String description,
            @RequestParam String[] primitiveCategories,
            @RequestParam(name = "file") MultipartFile uploadedFile
    ){

        if(userSvc.isUserLoggedIn()){
            User user = userSvc.getAuthUser();
            Report report = new Report(waterLevel, description);

            //add categories to report
            List<Category> categories = categoriesDao.findAll();
            List<String> primitive = Arrays.asList(primitiveCategories);
            List<Category> join = new ArrayList<>();
            for (int i = 0; i < categories.size(); i++) {
                String catName = categories.get(i).getName();
                if(primitive.contains(catName)){
                    join.add(categories.get(i));
                }
            }


            report.setCategories(join);
            report.setUser(user);

            //!test
            report.setQuery(query);
            report.setLatitude("lattt");
            report.setLongitude("longg");
            reportsDao.save(report);

            String token = enviromentSvc.getMapboxKey();
            geocodeSvc.executeSearch(query, token, user, report);

            //! FILE FUNCTION
            System.out.println("UPLOADED FILE: "+ uploadedFile);
            reportSvc.saveFile(uploadedFile, report);
            System.out.println("finished");

            return "redirect:/map";
        }
        return "redirect:/login";

    }


    @GetMapping("/test")
    @ResponseBody
    public String testing(){
        Report report = new Report();
        report.setWaterInches(0);
        report.setDescription("test desc");
        report.setZipcode(12345);
        report.setLatitude("lat");
        report.setLongitude("long");
        report.setCategories(categoriesDao.findAll());

        User user = userSvc.getAuthUser();
        report.setUser(user);
        reportsDao.save(report);
        return "test";

    }
}

